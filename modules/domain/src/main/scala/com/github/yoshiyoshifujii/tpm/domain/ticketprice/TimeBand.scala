package com.github.yoshiyoshifujii.tpm.domain.ticketprice

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

sealed abstract class TimeBand(override val entryName: String) extends EnumEntry

object TimeBand extends Enum[TimeBand] with EnumWithValidation[TimeBand] {
  override def values: immutable.IndexedSeq[TimeBand] = findValues

  case object `〜20:00`       extends TimeBand("〜20:00")
  case object `20:00〜 （レイト）` extends TimeBand("20:00〜 （レイト）")
}
