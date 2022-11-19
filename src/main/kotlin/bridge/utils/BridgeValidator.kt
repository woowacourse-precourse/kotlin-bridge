package bridge.utils

class BridgeValidator : Validator {
    override fun validate(input: String) {
        require(input.toIntOrNull() in MINIMUM_VALUE..MAXIMUM_VALUE) { ERROR_MESSAGE }
    }

    companion object {
        const val MINIMUM_VALUE = 3
        const val MAXIMUM_VALUE = 20
        const val ERROR_MESSAGE = "다리 길이는 3 부터 20 사이의 숫자여야 합니다."
    }
}