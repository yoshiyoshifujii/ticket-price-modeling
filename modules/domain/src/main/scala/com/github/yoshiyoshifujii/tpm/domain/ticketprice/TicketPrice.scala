package com.github.yoshiyoshifujii.tpm.domain.ticketprice

import com.github.yoshiyoshifujii.tpm.domain.schedule.{DayOfWeek, TimeZone}

trait TicketPrice {

  val ticketCategory: TicketCategory
  val price: Price
  val dayOfWeek: DayOfWeek
  val timeZone: TimeZone

}
