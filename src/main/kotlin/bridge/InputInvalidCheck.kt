package bridge

class InputInvalidCheck() {
    fun checkBridgeSize(input: String, inputConverter: InputConverter) {
        checkInputOneInteger(input)
        val bridgeSize = inputConverter.convertBridgeSize(input)
        if (bridgeSize < InputView.BRIDGE_LOWER_INCLUSIVE || bridgeSize > InputView.BRIDGE_UPPER_INCLUSIVE)
            throwError(Error.BRIDGE_INPUT_ERROR)
    }

    private fun checkInputOneInteger(input: String) {
        if (!input.isNumber()) throwError(Error.BRIDGE_INPUT_TYPE_ERROR)
    }

    private fun String.isNumber(): Boolean = this.all { it.isDigit() }

    fun checkMoving(input: String) {
        if (!(input == "U" || input == "D")) throwError(Error.MOVE_INPUT_ERROR)
    }

    fun checkGameCommand(input: String) {
        if (!(input == "R" || input == "Q")) throwError(Error.RETRY_INPUT_ERROR)
    }

    private fun throwError(e: Error) {
        if (e == Error.BRIDGE_INPUT_TYPE_ERROR)
            throw NumberFormatException(e.message)
        throw IllegalArgumentException(e.message)
    }

    enum class Error(val message: String) {
        BRIDGE_INPUT_TYPE_ERROR("[ERROR] 다리 길이에 대한 입력은 숫자만 가능합니다."),
        BRIDGE_INPUT_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
        MOVE_INPUT_ERROR("[ERROR] 이동에 대한 입력은 U(위) 혹은 D(아래)만 가능합니다."),
        RETRY_INPUT_ERROR("[ERROR] 게임 재시도에 대한 입력은 R(재시도) 혹은 Q(종료)만 가능합니다."),
    }
}