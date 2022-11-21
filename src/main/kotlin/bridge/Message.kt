package bridge

object Message {
    private const val PREFIX = "[ERROR]"
    private fun String.applyPrefix(): String = "$PREFIX $this"

    enum class InputViewEnum(private val msg: String) {
        INVALID_MSG("올바른 값을 입력해주세요.");

        override fun toString(): String = msg.applyPrefix()
    }

    enum class OutputViewEnum(private val msg: String) {
        INVALID_STATE("0 또는 1이 아닙니다.");
        override fun toString(): String = msg.applyPrefix()
    }
}