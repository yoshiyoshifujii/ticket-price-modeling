package com.github.yoshiyoshifujii.tpm.domain.customer

import cats.implicits._
import com.github.j5ik2o.dddbase.AggregateStringId
import com.github.yoshiyoshifujii.tpm.domain.{ DomainError, DomainValidationResult, ValueObject }
import com.github.yoshiyoshifujii.tpm.infrastructure.ulid.ULID

case class CustomerId(breachEncapsulationOfValue: ULID = ULID.generate) extends AggregateStringId {
  override val value: String = breachEncapsulationOfValue.asString
}

object CustomerId extends ValueObject[String, CustomerId] {
  override val validate: String => DomainValidationResult[CustomerId] =
    ULID
      .parseFromString(_)
      .fold(
        cause => DomainError(cause.toString).invalidNel,
        CustomerId(_).validNel
      )
}
