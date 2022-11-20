package bridge.utils

class MovementValidator : Validator {
    private val options = listOf("U", "D")

    override fun validate(input: String) {
        require(options.contains(input)) { ERROR_MESSAGE }
    }

    companion object {
        const val ERROR_MESSAGE = "이동할 칸은 U 또는 D 여야 합니다."
    }
}