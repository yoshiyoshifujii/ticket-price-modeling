package com.github.yoshiyoshifujii.tpm.domain.schedule

import com.github.j5ik2o.dddbase.Aggregate
import com.github.yoshiyoshifujii.tpm.domain.movie.MovieId

import scala.reflect._

trait Schedule extends Aggregate {
  override type AggregateType = Schedule
  override type IdType        = ScheduleId
  override protected val tag: ClassTag[Schedule] = classTag[Schedule]

  val movieId: MovieId
  val dayOfWeek: DayOfWeek
  val timeZone: TimeZone

}
