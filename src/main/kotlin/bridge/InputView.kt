package bridge

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    private val validator =  Validator()
    fun readBridgeSize(): Int {
        println(BRIDGE_SIZE_MESSAGE)
        val bridgeSize = readLine()
        return validator.validateBridgeSize(bridgeSize)
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(BRIDGE_MOVING_MESSAGE)
        val move = readLine()
        return validator.validatorMove(move)
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(GAME_COMMAND_MESSAGE)
        val command = readLine()
        return validator.validatorGameCommand(command)
    }
}
