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

    private val _movingResults = mutableListOf<MovingResult>()
    val movingResults get() = _movingResults as List<MovingResult>

    fun move(moving: String) {
        requireState(BridgeGameState.ONGOING) { ERROR_GAME_ALREADY_END }
        val direction = Direction.getByCommand(moving)
        val moveSuccess = bridge.canCross(direction, ++currentPosition)
        setState(moveSuccess)
        _movingResults.add(MovingResult(direction, moveSuccess))
    }

    fun retry(command: String) {
        requireState(BridgeGameState.FAIL) { ERROR_GAME_NOT_END }
        val gameCommand = BridgeGameCommand.getByCommand(command)
        runGameCommand(gameCommand)
    }

    fun isOnGoing() = (currentState == BridgeGameState.ONGOING)

    fun isFailed() = (currentState == BridgeGameState.FAIL)

    private fun runGameCommand(gameCommand: BridgeGameCommand) {
        if (gameCommand == BridgeGameCommand.RETRY && movingResults.isNotEmpty()) {
            _movingResults.clear()
            currentPosition = -1
            _tryCount += 1
            _currentState = BridgeGameState.ONGOING
        }
    }

    private fun requireState(state: BridgeGameState, lazyMessage: () -> String) {
        if (currentState != state) {
            val msg = lazyMessage()
            throw IllegalStateException(msg)
        }
    }

    private fun allPassed(): Boolean {
        return bridge.isBridgeEnd(currentPosition)
    }

    private fun setState(moveSuccess: Boolean) {
        _currentState = when {
            moveSuccess.not() -> BridgeGameState.FAIL
            moveSuccess && allPassed() -> BridgeGameState.PASS
            else -> currentState
        }
    }

    companion object {
        private const val ERROR_GAME_NOT_END = "게임이 아직 진행중 입니다."
        private const val ERROR_GAME_ALREADY_END = "게임이 이미 종료되었습니다."
    }
}
