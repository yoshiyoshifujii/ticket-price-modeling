package com.github.yoshiyoshifujii.tpm.domain.ticketprice

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

sealed abstract class Price(override val entryName: String, val value: Option[Int]) extends EnumEntry

object Price extends Enum[Price] with EnumWithValidation[Price] {
  override def values: immutable.IndexedSeq[Price] = findValues

  case object `適用なし`   extends Price("適用なし", None)
  case object `900円`   extends Price("900円", Some(900))
  case object `1,000円` extends Price("1,000円", Some(1000))
  case object `1,100円` extends Price("1,100円", Some(1100))
  case object `1,300円` extends Price("1,300円", Some(1300))
  case object `1,400円` extends Price("1,400円", Some(1400))
  case object `1,500円` extends Price("1,500円", Some(1500))
  case object `1,600円` extends Price("1,600円", Some(1600))
  case object `1,800円` extends Price("1,800円", Some(1800))
  case object `2,200円` extends Price("2,200円", Some(2200))
}
