package com.github.yoshiyoshifujii.tpm.domain.ticketprice

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

sealed abstract class DayBand(override val entryName: String) extends EnumEntry

object DayBand extends Enum[DayBand] with EnumWithValidation[DayBand] {
  override def values: immutable.IndexedSeq[DayBand] = findValues

  case object `平日`  extends DayBand("平日")
  case object `土日祝` extends DayBand("土日祝")
}
