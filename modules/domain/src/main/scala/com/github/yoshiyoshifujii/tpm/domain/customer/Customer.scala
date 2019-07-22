package com.github.yoshiyoshifujii.tpm.domain.customer

import com.github.j5ik2o.dddbase.Aggregate

import scala.reflect._

trait Customer extends Aggregate {
  override type AggregateType = Customer
  override type IdType        = CustomerId
  override protected val tag: ClassTag[Customer] = classTag[Customer]

  val permissibleAges: PermissibleAges
  val permissibleSex: PermissibleSex
  val permissibleHandicapped: PermissibleHandicapped

}
