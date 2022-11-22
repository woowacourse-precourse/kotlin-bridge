package bridge.data

sealed class InputError {
    data class BridgeSizeInputError(val errorMessage: String): InputError()
    data class MovingInputError(val errorMessage: String): InputError()
    data class GameCommandInputError(val errorMessage: String): InputError()
}