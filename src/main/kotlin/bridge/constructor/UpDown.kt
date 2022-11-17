package bridge

enum class UpDown() {
    D,
    U;

    companion object {
        private const val SHOULD_ZERO_OR_ONE = "[ERROR] 랜덤 생성 번호는 0 혹은 1이어야합니다."
        fun judgeUpDown(randomNumber: Int): String {
            values().forEach {
                if (it.ordinal == randomNumber) return it.name
            }
            throw IllegalArgumentException(SHOULD_ZERO_OR_ONE)
        }
    }
}
