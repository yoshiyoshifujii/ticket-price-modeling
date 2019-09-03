package com.github.yoshiyoshifujii.tpm.domain.screeningSchedule

import com.github.j5ik2o.dddbase.Aggregate
import com.github.yoshiyoshifujii.tpm.domain.movie.MovieId

import scala.reflect._

trait ScreeningSchedule extends Aggregate {
  override type AggregateType = ScreeningSchedule
  override type IdType        = ScreeningScheduleId
  override protected val tag: ClassTag[ScreeningSchedule] = classTag[ScreeningSchedule]

  val movieId: MovieId
  val date: ScreeningDate
  val startTime: ScreeningStartTime
  val endTime: ScreeningEndTime

}
