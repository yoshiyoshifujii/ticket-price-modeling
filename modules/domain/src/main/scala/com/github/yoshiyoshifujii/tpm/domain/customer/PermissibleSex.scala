package com.github.yoshiyoshifujii.tpm.domain.customer

case class PermissibleSex(breachEncapsulationOfValue: Set[Sex]) {
  assert(breachEncapsulationOfValue.size <= Sex.values.size)
}
