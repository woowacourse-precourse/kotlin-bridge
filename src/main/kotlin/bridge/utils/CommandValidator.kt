package bridge.utils

class CommandValidator : Validator {
    private val options = listOf("R", "Q")

    override fun validate(input: String) {
        require(options.contains(input)) { ERROR_MESSAGE }
    }

    companion object {
        const val ERROR_MESSAGE = "명령어는 R 또는 Q 여야 합니다."
    }
}