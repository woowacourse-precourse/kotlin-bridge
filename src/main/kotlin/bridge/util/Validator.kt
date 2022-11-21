package bridge.util

object Validator {
    private val BRIDGE_MIN_SIZE = 3
    private val BRIDGE_MAX_SIZE = 20
    private val CAN_MOVE_BRIDGE = "UD"
    private val GAME_COMMAND = "RQ"

    fun checkBridgeSize(size: String) {
        if (size.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.")
        }

        var bridgeSize = size.toInt()

        if (bridgeSize !in BRIDGE_MIN_SIZE..BRIDGE_MAX_SIZE) {
            throw IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해주세요.")
        }
    }

    fun checkBridgeSelect(move: String) {
        if (move !in CAN_MOVE_BRIDGE) {
            throw IllegalArgumentException("[ERROR] U 또는 D를 입력해주세요.")
        }
    }

    fun checkCommand(command: String) {
        if (command !in GAME_COMMAND) {
            throw IllegalArgumentException("[ERROR] R 또는 Q를 입력해주세요.")
        }
    }
}