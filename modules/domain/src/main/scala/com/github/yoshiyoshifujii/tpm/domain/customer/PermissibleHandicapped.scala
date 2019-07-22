package com.github.yoshiyoshifujii.tpm.domain.customer

case class PermissibleHandicapped(breachEncapsulationOfValue: Set[Handicapped]) {
  assert(breachEncapsulationOfValue.size <= Handicapped.values.size)
}
