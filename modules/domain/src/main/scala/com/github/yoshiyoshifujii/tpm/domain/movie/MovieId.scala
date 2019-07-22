package com.github.yoshiyoshifujii.tpm.domain.movie

import cats.implicits._
import com.github.j5ik2o.dddbase.AggregateStringId
import com.github.yoshiyoshifujii.tpm.domain.{ DomainError, DomainValidationResult, ValueObject }
import com.github.yoshiyoshifujii.tpm.infrastructure.ulid.ULID

case class MovieId(breachEncapsulationOfValue: ULID = ULID.generate) extends AggregateStringId {
  override val value: String = breachEncapsulationOfValue.asString
}

object MovieId extends ValueObject[String, MovieId] {
  override val validate: String => DomainValidationResult[MovieId] =
    ULID
      .parseFromString(_)
      .fold(
        cause => DomainError(cause.toString).invalidNel,
        MovieId(_).validNel
      )
}
