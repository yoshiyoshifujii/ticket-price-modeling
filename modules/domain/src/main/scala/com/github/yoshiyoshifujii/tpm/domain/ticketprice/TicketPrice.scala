package com.github.yoshiyoshifujii.tpm.domain.ticketprice

trait TicketPrice {

  val ticketType: TicketType
  val price: Price
  val dayBand: DayBand
  val timeBand: TimeBand

}
