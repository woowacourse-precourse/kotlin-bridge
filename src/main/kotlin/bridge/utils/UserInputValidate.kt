package bridge.utils

class UserInputValidate {
    fun validateBridgeSize(inputBridgeSize: String): Int {
        isValidType(inputBridgeSize)
        isValidInputRange(inputBridgeSize.toInt())
        return inputBridgeSize.toInt()
    }

    private fun isNumber(s: String?): Boolean {
        return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
    }

    private fun isValidType(bridgeSize: String) {
        if (!isNumber(bridgeSize)) {
            throw IllegalArgumentException("[ERROR]: 다리의 길이는 숫자로만 입력되어야 합니다.")
        }
    }

    private fun isValidInputRange(bridgeSize: Int) {
        if (bridgeSize < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < bridgeSize) {
            throw IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
        }
    }

    fun validateMoving(inputMoving: String): String {
        isValidMovingInput(inputMoving)
        return inputMoving
    }

    private fun isValidMovingInput(inputMoving: String) {
        if (inputMoving.length != INPUT_MOVING_LENGTH || !inputMoving.contains("U") && !inputMoving.contains("D")) {
            throw IllegalArgumentException("[ERROR] 이동할 칸의 입력은 U(위 칸)와 D(아래 칸) 중 하나여야 합니다.")
        }
    }

    fun validateGameCommand(inputMoving: String): String {
        isValidGameCommand(inputMoving)
        return inputMoving
    }

    private fun isValidGameCommand(inputMoving: String) {
        if (inputMoving.length != 1 || !inputMoving.contains("Q") && !inputMoving.contains("R")) {
            throw IllegalArgumentException("[ERROR] 게임 재시작/종료 여부 입력은 R(재시작)과 Q(종료) 중 하나여야 합니다.")
        }
    }

    companion object {
        const val MIN_BRIDGE_SIZE = 3
        const val MAX_BRIDGE_SIZE = 20
        const val INPUT_MOVING_LENGTH = 1
    }
}