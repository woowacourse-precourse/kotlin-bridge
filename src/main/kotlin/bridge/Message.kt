package bridge

object Message {
    private const val PREFIX = "[ERROR]"
    private fun String.applyPrefix(): String = "$PREFIX $this"

    enum class InputViewEnum(private val msg: String) {
        INVALID_LENGTH("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
        INVALID_MOVE("이동할 수 있는 방법은 U 또는 D입니다."),
        INVALID_RESTART("재시작 또는 종료 방법은 R또는 Q입니다.");

        override fun toString(): String = msg.applyPrefix()
    }

    enum class OutputViewEnum(private val msg: String) {
        INVALID_STATE("0 또는 1이 아닙니다.");

        override fun toString(): String = msg.applyPrefix()
    }

    enum class BridgeGameEnum(private val msg: String) {
        SUCCESS("게임 성공 여부: 성공\n총 시도한 횟수: %d"),
        FAIL("게임 성공 여부: 실패\n총 시도한 횟수: %d");

        override fun toString(): String = msg
    }

    enum class ControllerEnum(val state: Boolean) {
        RUNNING(true),
        STOP(false)
    }
}