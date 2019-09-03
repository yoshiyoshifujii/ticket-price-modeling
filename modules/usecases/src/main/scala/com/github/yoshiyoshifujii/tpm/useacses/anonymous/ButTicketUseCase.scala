package com.github.yoshiyoshifujii.tpm.useacses.anonymous

import cats.implicits._
import com.github.yoshiyoshifujii.tpm.domain.screeningSchedule.ScreeningScheduleId
import com.github.yoshiyoshifujii.tpm.domain.ticket._
import com.github.yoshiyoshifujii.tpm.domain.ticketprice.TicketPrice
import com.github.yoshiyoshifujii.tpm.repositories.{ ScreeningScheduleRepository, TicketRepository }
import com.github.yoshiyoshifujii.tpm.useacses._

case class BuyTicketInputData(screeningScheduleId: ScreeningScheduleId,
                              sex: Sex,
                              ageType: AgeType,
                              discount: Option[DiscountType])
case class BuyTicketOutputData(ticketId: TicketId, ticketPrice: TicketPrice)

class ButTicketUseCase[F[_]](
    screeningScheduleRepository: ScreeningScheduleRepository[F],
    ticketRepository: TicketRepository[F]
) extends UseCase[F, BuyTicketInputData, BuyTicketOutputData] {
  override def execute(inputData: BuyTicketInputData)(implicit ME: UseCaseMonadError[F]): F[BuyTicketOutputData] =
    for {
      schedule <- screeningScheduleRepository.resolveById(inputData.screeningScheduleId)
      ticket = Ticket.generate(
        schedule,
        inputData.sex,
        inputData.ageType,
        inputData.discount
      )
      price <- ticket.howMuch.toF
      _     <- ticketRepository.store(ticket)
    } yield BuyTicketOutputData(ticket.id, price)
}
