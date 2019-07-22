package com.github.yoshiyoshifujii.tpm.domain.customer

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

sealed abstract class Age(override val entryName: String) extends EnumEntry

object Age extends Enum[Age] with EnumWithValidation[Age] {
  override def values: immutable.IndexedSeq[Age] = findValues

  case object `幼児・小学生`    extends Age("幼児・小学生")
  case object `中学生`       extends Age("中学生")
  case object `高校生`       extends Age("高校生")
  case object `大学生・専門学校生` extends Age("大学生・専門学校生")
  case object `10代`       extends Age("10代")
  case object `20代`       extends Age("20代")
  case object `30代`       extends Age("30代")
  case object `40代`       extends Age("40代")
  case object `50代`       extends Age("50代")
  case object `60代`       extends Age("60代")
  case object `70代以上`     extends Age("70代以上")
}
