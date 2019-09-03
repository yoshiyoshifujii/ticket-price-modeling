package com.github.yoshiyoshifujii.tpm.repositories

import com.github.j5ik2o.dddbase.AggregateSingleReader
import com.github.yoshiyoshifujii.tpm.domain.screeningSchedule.{ ScreeningSchedule, ScreeningScheduleId }

trait ScreeningScheduleRepository[F[_]] extends AggregateSingleReader[F] {
  override type AggregateType = ScreeningSchedule
  override type IdType        = ScreeningScheduleId
}
