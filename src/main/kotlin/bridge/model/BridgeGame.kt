package bridge.model

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: Bridge) {
    private var currentPosition: Int = -1

    private var _tryCount: Int = 1
    val tryCount: Int
        get() = _tryCount

    private var _state = BridgeGameState.ONGOING
    val state
        get() = _state

    private val _movingTrace = ArrayDeque<Pair<String, Boolean>>()
    val movingTrace: List<Pair<String, Boolean>>
        get() = _movingTrace

    /**
     * @param moving 이동 방향
     * @throws IllegalStateException 현재 위치와 다리 길이 매칭 오류
     * @throws IllegalArgumentException moving이 Direction에 포함되지 않은 경우
     */
    fun move(moving: String) {
        requireOnGoing()
        try {
            currentPosition += 1
            val passed = bridge.available(moving, currentPosition)
            setState(passed)
            _movingTrace.addLast(moving to passed)
        } catch (e: IndexOutOfBoundsException) {
            throw IllegalStateException(ERROR_POSITION_BOUND)
        }
    }

    /**
     * @param command 게임 커맨드 문자
     * @return 재시도 여부
     * @throws IllegalArgumentException 없는 커맨드로 호출
     */
    fun retry(command: String): Boolean {
        require(command in setOf(COMMAND_QUIT, COMMAND_RETRY)) { ERROR_COMMAND_MATCH }
        return runCommand(command)
    }

    private fun runCommand(command: String): Boolean {
        if (command == COMMAND_RETRY) {
            _movingTrace.removeLastOrNull() // TODO
            currentPosition -= 1
            _tryCount += 1
            _state = BridgeGameState.ONGOING
            return true
        }
        return false
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
        private const val ERROR_COMMAND_MATCH = "커맨드가 올바르지 않습니다."
        private const val COMMAND_RETRY = "R"
        private const val COMMAND_QUIT = "Q"
    }
}
