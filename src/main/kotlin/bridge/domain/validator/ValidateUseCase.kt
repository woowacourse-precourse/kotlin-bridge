package bridge.domain.validator

data class ValidateUseCase(
    val validateBridgeSize: ValidateBridgeSize = ValidateBridgeSize(),
    val validateMoving: ValidateMoving = ValidateMoving(),
    val validateGameCommand: ValidateGameCommand = ValidateGameCommand()
)