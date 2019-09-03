package com.github.yoshiyoshifujii.tpm.domain.ticket

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

sealed abstract class DiscountType(override val entryName: String) extends EnumEntry

object DiscountType extends Enum[DiscountType] with EnumWithValidation[DiscountType] {
  override def values: immutable.IndexedSeq[DiscountType] = findValues

  case object `シティズン・平日`          extends DiscountType("シティズン・平日")
  case object `シティズン・シニア(60歳以上)`  extends DiscountType("シティズン・シニア(60歳以上)")
  case object `障がい者 (同伴者も)`       extends DiscountType("障がい者 (同伴者も)")
  case object `高校生以下の障がい者 (同伴者も)` extends DiscountType("高校生以下の障がい者 (同伴者も)")
}
