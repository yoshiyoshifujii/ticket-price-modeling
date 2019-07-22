package com.github.yoshiyoshifujii.tpm.infrastructure.ulid

import net.petitviolet.ulid4s.{ ULID => ULID4S }

import scala.util.{ Failure, Success, Try }

case class ULID(private val value: String) {
  assert(ULID4S.isValid(value))

  def asString: String = value
}

object ULID {

  def generate: ULID = ULID(ULID4S.generate)

  def parseFromString(value: String): Try[ULID] =
    if (ULID4S.isValid(value))
      Success(ULID(value))
    else
      Failure(ULIDParseException(s"$value"))

}
