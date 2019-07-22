package com.github.yoshiyoshifujii.tpm.domain.schedule

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

sealed abstract class TimeZone(override val entryName: String) extends EnumEntry

object TimeZone extends Enum[TimeZone] with EnumWithValidation[TimeZone] {
  override def values: immutable.IndexedSeq[TimeZone] = findValues

  case object `〜20:00`       extends TimeZone("〜20:00")
  case object `20:00〜 （レイト）` extends TimeZone("20:00〜 （レイト）")
}
