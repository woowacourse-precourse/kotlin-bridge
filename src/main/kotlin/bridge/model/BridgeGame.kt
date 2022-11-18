package bridge.model

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: Bridge) {
    data class MovingResult(val direction: Direction, val success: Boolean)

    private var currentPosition = -1

    private var _tryCount = 1
    val tryCount get() = _tryCount

    private var _state = BridgeGameState.ONGOING
    val state get() = _state

    private val _movingTrace = ArrayDeque<MovingResult>()
    val movingTrace get() = _movingTrace as List<MovingResult>

    fun move(moving: String) {
        requireOnGoing()
        val direction = Direction.getByDisplayName(moving)
        val success = canCross(direction, ++currentPosition)
        setState(success)
        _movingTrace.addLast(MovingResult(direction, success))
    }

    fun retry(command: String) {
        val gameCommand = BridgeGameCommand.getByCommand(command)
        runCommand(gameCommand)
    }

    fun isOnGoing() = (state == BridgeGameState.ONGOING)

    fun isFail() = (state == BridgeGameState.FAIL)

    private fun canCross(direction: Direction, position: Int): Boolean {
        return try {
            bridge.canCross(direction, position)
        } catch (e: IndexOutOfBoundsException) {
            throw IllegalStateException(ERROR_POSITION_BOUND)
        }
    }

    private fun runCommand(gameCommand: BridgeGameCommand) {
        if (gameCommand == BridgeGameCommand.RETRY && movingTrace.isNotEmpty()) {
            _movingTrace.removeLast()
            currentPosition -= 1
            _tryCount += 1
            _state = BridgeGameState.ONGOING
        }
    }

    private fun requireOnGoing() {
        if (state != BridgeGameState.ONGOING) {
            throw IllegalStateException(ERROR_GAME_ALREADY_END)
        }
    }

    private fun allPassed(): Boolean {
        return bridge.isBridgeEnd(currentPosition)
    }

    private fun setState(passed: Boolean) {
        if (!passed) {
            _state = BridgeGameState.FAIL
        }
        if (passed && allPassed()) {
            _state = BridgeGameState.PASS
        }
    }

    companion object {
        private const val ERROR_POSITION_BOUND = "플레이어 현재 위치가 올바르지 않습니다."
        private const val ERROR_GAME_ALREADY_END = "게임이 이미 종료되었습니다."
    }
}
