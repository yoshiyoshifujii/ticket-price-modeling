package com.github.yoshiyoshifujii.tpm

import cats.MonadError
import com.github.yoshiyoshifujii.tpm.domain.DomainValidationResult

package object useacses {

  type UseCaseMonadError[F[_]] = MonadError[F, UseCaseError]

  implicit class DomainError2MonadError[A](val v: DomainValidationResult[A]) extends AnyVal {
    def toF[F[_]](implicit ME: UseCaseMonadError[F]): F[A] =
      v.fold(
        ne => ME.raiseError(UseCaseApplicationError(ne)),
        ME.pure
      )
  }
}
