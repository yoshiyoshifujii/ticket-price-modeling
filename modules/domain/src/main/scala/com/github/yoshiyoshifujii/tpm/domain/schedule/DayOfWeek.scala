package com.github.yoshiyoshifujii.tpm.domain.schedule

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

sealed abstract class DayOfWeek(override val entryName: String) extends EnumEntry

object DayOfWeek extends Enum[DayOfWeek] with EnumWithValidation[DayOfWeek] {
  override def values: immutable.IndexedSeq[DayOfWeek] = findValues

  case object `平日`  extends DayOfWeek("平日")
  case object `土日祝` extends DayOfWeek("土日祝")
}
