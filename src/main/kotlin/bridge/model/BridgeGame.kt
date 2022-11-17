package bridge.model

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: Bridge) {

    private var currentPosition: Int = -1
    private var _tryCount: Int = 1
    val tryCount: Int
        get() = _tryCount

    /**
     * @param moving 이동 방향
     * @return 이동 성공 여부(방향 일치 여부만 확인)
     * @throws IllegalStateException 현재 위치와 다리 길이 매칭 오류
     */
    fun move(moving: String): Boolean {
        return try {
            currentPosition += 1
            bridge.available(moving, currentPosition)
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
        if (command == COMMAND_RETRY) {
            currentPosition -= 1
            _tryCount += 1
            return true
        }
        return false
    }

    fun isEnd(): Boolean {
        return bridge.isBridgeEnd(currentPosition)
    }

    companion object {
        private const val ERROR_POSITION_BOUND = "플레이어 현재 위치가 올바르지 않습니다."
        private const val ERROR_COMMAND_MATCH = "커맨드가 올바르지 않습니다."
        private const val COMMAND_RETRY = "R"
        private const val COMMAND_QUIT = "Q"
    }
}
