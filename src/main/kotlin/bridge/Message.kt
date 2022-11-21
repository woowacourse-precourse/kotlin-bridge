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

    enum class BridgeGameEnum(private val msg: String){
        SUCCESS("게임 성공 여부: 성공\n총 시도한 횟수: %d"),
        FAIL("게임 성공 여부: 실패\n총 시도한 횟수: %d");

        override fun toString(): String = msg
    }
}