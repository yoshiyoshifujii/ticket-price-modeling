package com.github.yoshiyoshifujii.tpm.domain.customer

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

sealed abstract class Sex(override val entryName: String) extends EnumEntry

object Sex extends Enum[Sex] with EnumWithValidation[Sex] {
  override def values: immutable.IndexedSeq[Sex] = findValues

  case object `男性` extends Sex("男性")
  case object `女性` extends Sex("女性")
}
