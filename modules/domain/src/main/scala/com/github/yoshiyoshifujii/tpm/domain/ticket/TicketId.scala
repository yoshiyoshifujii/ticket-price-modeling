package com.github.yoshiyoshifujii.tpm.domain.ticket

import cats.implicits._
import com.github.j5ik2o.dddbase.AggregateStringId
import com.github.yoshiyoshifujii.tpm.domain.{ DomainError, DomainValidationResult, ValueObject }
import com.github.yoshiyoshifujii.tpm.infrastructure.ulid.ULID

case class TicketId(breachEncapsulationOfValue: ULID = ULID.generate) extends AggregateStringId {
  override val value: String = breachEncapsulationOfValue.asString
}

object TicketId extends ValueObject[String, TicketId] {
  override val validate: String => DomainValidationResult[TicketId] =
    ULID
      .parseFromString(_)
      .fold(
        cause => DomainError(cause.toString).invalidNel,
        TicketId(_).validNel
      )
}
