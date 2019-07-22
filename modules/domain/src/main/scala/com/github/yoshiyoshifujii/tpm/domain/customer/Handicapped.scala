package com.github.yoshiyoshifujii.tpm.domain.customer

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

sealed abstract class Handicapped(override val entryName: String) extends EnumEntry

object Handicapped extends Enum[Handicapped] with EnumWithValidation[Handicapped] {
  override def values: immutable.IndexedSeq[Handicapped] = findValues

  case object `障がい者 (同伴者も)` extends Handicapped("障がい者 (同伴者も)")
  case object `高校生以下の障がい者 (同伴者も)` extends Handicapped("高校生以下の障がい者 (同伴者も)")
}

