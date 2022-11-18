package bridge.validator

object InputValidator {
    fun validateBridgeSize(input: Int) {
        if (input < 3 || input > 20) throw IllegalArgumentException("[ERROR] 잘못된 값을 입력 했습니다. 다시 입력해 주세요")
    }
}

