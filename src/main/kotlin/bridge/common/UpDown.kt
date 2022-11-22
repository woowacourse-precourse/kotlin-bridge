package bridge.common

enum class UpDown(val up: String, val down: String, val upMismatch: String, val downMismatch: String) {
    D(" ", "O", " ", "X"),
    U("O", " ", "X", " ");

    companion object {
        private const val SHOULD_ZERO_OR_ONE = "[ERROR] 랜덤 생성 번호는 0 혹은 1이어야합니다."
        fun judgeUpDown(randomNumber: Int): String {
            return values().find { it.ordinal == randomNumber }?.name
                ?: throw IllegalArgumentException(SHOULD_ZERO_OR_ONE)
        }
    }
}
