package com.github.yoshiyoshifujii.tpm.domain.screeningSchedule

import cats.implicits._
import com.github.j5ik2o.dddbase.AggregateStringId
import com.github.yoshiyoshifujii.tpm.domain.{ DomainError, DomainValidationResult, ValueObject }
import com.github.yoshiyoshifujii.tpm.infrastructure.ulid.ULID

case class ScreeningScheduleId(breachEncapsulationOfValue: ULID = ULID.generate) extends AggregateStringId {
  override val value: String = breachEncapsulationOfValue.asString
}

object ScreeningScheduleId extends ValueObject[String, ScreeningScheduleId] {
  override val validate: String => DomainValidationResult[ScreeningScheduleId] =
    ULID
      .parseFromString(_)
      .fold(
        cause => DomainError(cause.toString).invalidNel,
        ScreeningScheduleId(_).validNel
      )
}
