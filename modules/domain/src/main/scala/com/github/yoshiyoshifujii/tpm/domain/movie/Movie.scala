package com.github.yoshiyoshifujii.tpm.domain.movie

import com.github.j5ik2o.dddbase.Aggregate

import scala.reflect._

trait Movie extends Aggregate {
  override type AggregateType = Movie
  override type IdType        = MovieId
  override protected val tag: ClassTag[Movie] = classTag[Movie]

  val title: String

}
