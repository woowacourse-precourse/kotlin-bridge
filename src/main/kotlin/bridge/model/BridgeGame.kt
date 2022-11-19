package bridge.model

/**
 * 게임의 상태, 플레이어 위치, 이동 기록을 수정하며 관리하는 역활을 한다.
 */
class BridgeGame(private val bridge: Bridge) {
    data class MovingResult(val direction: Direction, val isSuccess: Boolean)

    private var currentPosition = -1

    private var _tryCount = 1
    val tryCount get() = _tryCount

    private var _currentState = BridgeGameState.ONGOING
    val currentState get() = _currentState

    private val _movingResults = ArrayDeque<MovingResult>()
    val movingResults get() = _movingResults as List<MovingResult>

    fun move(moving: String) {
        requireOnGoing()
        val direction = Direction.getByDisplayName(moving)
        val isSuccess = canCross(direction, ++currentPosition)
        setState(isSuccess)
        _movingResults.addLast(MovingResult(direction, isSuccess))
    }

    fun retry(command: String) {
        val gameCommand = BridgeGameCommand.getByCommand(command)
        runCommand(gameCommand)
    }

    fun isOnGoing() = (currentState == BridgeGameState.ONGOING)

    fun isFailed() = (currentState == BridgeGameState.FAIL)

    private fun canCross(direction: Direction, position: Int): Boolean {
        return try {
            bridge.canCross(direction, position)
        } catch (e: IndexOutOfBoundsException) {
            throw IllegalStateException(ERROR_POSITION_BOUND)
        }
    }

    private fun runCommand(gameCommand: BridgeGameCommand) {
        if (gameCommand == BridgeGameCommand.RETRY && movingResults.isNotEmpty()) {
            _movingResults.clear()
            currentPosition = -1
            _tryCount += 1
            _currentState = BridgeGameState.ONGOING
        }
    }

    private fun requireOnGoing() {
        if (currentState != BridgeGameState.ONGOING) {
            throw IllegalStateException(ERROR_GAME_ALREADY_END)
        }
    }

    private fun allPassed(): Boolean {
        return bridge.isBridgeEnd(currentPosition)
    }

    private fun setState(isSuccess: Boolean) {
        _currentState = when {
            isSuccess.not() -> BridgeGameState.FAIL
            isSuccess && allPassed() -> BridgeGameState.PASS
            else -> currentState
        }
    }

    companion object {
        private const val ERROR_POSITION_BOUND = "플레이어 현재 위치가 올바르지 않습니다."
        private const val ERROR_GAME_ALREADY_END = "게임이 이미 종료되었습니다."
    }
}
