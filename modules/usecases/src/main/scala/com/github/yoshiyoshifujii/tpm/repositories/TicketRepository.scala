package com.github.yoshiyoshifujii.tpm.repositories

import com.github.j5ik2o.dddbase.AggregateSingleWriter
import com.github.yoshiyoshifujii.tpm.domain.ticket.{ Ticket, TicketId }

trait TicketRepository[F[_]] extends AggregateSingleWriter[F] {
  override type AggregateType = Ticket
  override type IdType        = TicketId
}
