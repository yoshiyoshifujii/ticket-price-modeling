package com.github.yoshiyoshifujii.tpm.domain.ticket

import com.github.j5ik2o.dddbase.Aggregate
import com.github.yoshiyoshifujii.tpm.domain.DomainValidationResult
import com.github.yoshiyoshifujii.tpm.domain.screeningSchedule.ScreeningSchedule
import com.github.yoshiyoshifujii.tpm.domain.ticketprice.TicketPrice

import scala.reflect._

trait Ticket extends Aggregate {
  override type AggregateType = Ticket
  override type IdType        = TicketId
  override protected val tag: ClassTag[Ticket] = classTag[Ticket]

  val screeningSchedule: ScreeningSchedule
  val sex: Sex
  val ageType: AgeType
  val discount: Option[DiscountType]

  def howMuch: DomainValidationResult[TicketPrice] = ???
}

object Ticket {
  def generate(
      screeningSchedule: ScreeningSchedule,
      sex: Sex,
      ageType: AgeType,
      discount: Option[DiscountType]
  ): Ticket = {
    val (a, b, c, d) = (screeningSchedule, sex, ageType, discount)
    new Ticket {
      override val id: TicketId                         = TicketId()
      override val screeningSchedule: ScreeningSchedule = a
      override val sex: Sex                             = b
      override val ageType: AgeType                     = c
      override val discount: Option[DiscountType]       = d
    }
  }
}
