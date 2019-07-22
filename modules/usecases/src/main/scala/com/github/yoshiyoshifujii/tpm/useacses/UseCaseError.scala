package com.github.yoshiyoshifujii.tpm.useacses

import cats.data.NonEmptyList
import com.github.yoshiyoshifujii.tpm.domain.DomainError

sealed trait UseCaseError

case class UseCaseSystemError(cause: Throwable) extends UseCaseError

case class UseCaseApplicationError(message: String) extends UseCaseError
object UseCaseApplicationError {
  def apply(message: NonEmptyList[DomainError]): UseCaseApplicationError =
    new UseCaseApplicationError(message.toString())
}
