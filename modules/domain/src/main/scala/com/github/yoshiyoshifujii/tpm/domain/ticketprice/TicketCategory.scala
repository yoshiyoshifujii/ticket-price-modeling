package com.github.yoshiyoshifujii.tpm.domain.ticketprice

import com.github.yoshiyoshifujii.tpm.domain.EnumWithValidation
import enumeratum._

import scala.collection.immutable

abstract sealed class TicketCategory(
    override val entryName: String,
    val description: Option[String],
    val enabled: Boolean
) extends EnumEntry

object TicketCategory extends Enum[TicketCategory] with EnumWithValidation[TicketCategory] {
  override def values: immutable.IndexedSeq[TicketCategory] = findValues

  case object `シネマシティズン`        extends TicketCategory("シネマシティズン", Some("※平日なら「映画の日」に関係なく1,000円！"), enabled = true)
  case object `シネマシティズン（60才以上）` extends TicketCategory("シネマシティズン（60才以上）", None, enabled = true)
  case object `一般`              extends TicketCategory("一般", None, enabled = true)
  case object `シニア（70才以上）`      extends TicketCategory("シニア（70才以上）", Some("身分証をご提示下さい。"), enabled = true)
  case object `学生（大・専）`         extends TicketCategory("学生（大・専）", Some("学生証をご提示下さい。"), enabled = true)
  case object `中・高校生`           extends TicketCategory("中・高校生", Some("生徒手帳をご提示下さい。"), enabled = true)
  case object `幼児（3才以上）・小学生`    extends TicketCategory("幼児（3才以上）・小学生", None, enabled = true)
  case object `障がい者（学生以上）`      extends TicketCategory("障がい者（学生以上）", Some("同伴者１名様も同額。手帳をご提示下さい。"), enabled = true)
  case object `障がい者（高校以下）`      extends TicketCategory("障がい者（高校以下）", Some("同伴者１名様も同額。手帳をご提示下さい。"), enabled = true)
  case object `夫婦50割引`          extends TicketCategory("夫婦50割引", Some("2019年3月31日をもって終了しました。"), enabled = false)
  case object `エムアイカード`         extends TicketCategory("エムアイカード", Some("1枚につき1名様。他割引との併用不可。"), enabled = true)
  case object `駐車場パーク80割引`      extends TicketCategory("駐車場パーク80割引", None, enabled = true)

}
