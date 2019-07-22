package com.github.yoshiyoshifujii.tpm.domain.customer

case class PermissibleAges(breachEncapsulationOfValue: Set[Age]) {
  assert(breachEncapsulationOfValue.size <= Age.values.size)
}
