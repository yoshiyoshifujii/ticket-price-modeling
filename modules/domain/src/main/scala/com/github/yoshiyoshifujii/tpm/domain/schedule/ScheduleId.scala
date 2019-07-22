package com.github.yoshiyoshifujii.tpm.domain.schedule

import cats.implicits._
import com.github.j5ik2o.dddbase.AggregateStringId
import com.github.yoshiyoshifujii.tpm.domain.{DomainError, DomainValidationResult, ValueObject}
import com.github.yoshiyoshifujii.tpm.infrastructure.ulid.ULID

case class ScheduleId(breachEncapsulationOfValue: ULID = ULID.generate) extends AggregateStringId {
  override val value: String = breachEncapsulationOfValue.asString
}

object ScheduleId extends ValueObject[String, ScheduleId] {
  override val validate: String => DomainValidationResult[ScheduleId] =
    ULID
      .parseFromString(_)
      .fold(
        cause => DomainError(cause.toString).invalidNel,
        ScheduleId(_).validNel
      )
}
