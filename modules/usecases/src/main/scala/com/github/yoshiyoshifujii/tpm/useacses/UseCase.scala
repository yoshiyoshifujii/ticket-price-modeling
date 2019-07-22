package com.github.yoshiyoshifujii.tpm.useacses

trait UseCase[F[_], InputData, OutputData] {

  def execute(inputData: InputData)(implicit ME: UseCaseMonadError[F]): F[OutputData]

}
