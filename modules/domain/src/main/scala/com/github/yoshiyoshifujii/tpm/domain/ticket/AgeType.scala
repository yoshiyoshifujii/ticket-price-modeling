package com.github.yoshiyoshifujii.tpm.domain.ticket

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

sealed abstract class AgeType(override val entryName: String) extends EnumEntry

object AgeType extends Enum[AgeType] with EnumWithValidation[AgeType] {
  override def values: immutable.IndexedSeq[AgeType] = findValues

  case object `幼児・小学生`    extends AgeType("幼児・小学生")
  case object `中学生`       extends AgeType("中学生")
  case object `高校生`       extends AgeType("高校生")
  case object `大学生・専門学校生` extends AgeType("大学生・専門学校生")
  case object `10代`       extends AgeType("10代")
  case object `20代`       extends AgeType("20代")
  case object `30代`       extends AgeType("30代")
  case object `40代`       extends AgeType("40代")
  case object `50代`       extends AgeType("50代")
  case object `60代`       extends AgeType("60代")
  case object `70代以上`     extends AgeType("70代以上")
}
