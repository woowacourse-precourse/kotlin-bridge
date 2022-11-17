package bridge.model

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: Bridge, private var currentPosition: Int = 0) {
    /**
     * @param moving 이동 방향
     * @return 이동 성공 여부(방향 일치 여부만 확인)
     * @throws IllegalStateException
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
     * @param
     * @return
     */
    fun retry() {}

    fun isEnd(): Boolean {
        return bridge.isBridgeEnd(currentPosition)
    }

    companion object {
        private const val ERROR_POSITION_BOUND = "플레이어 현재 위치가 올바르지 않습니다."
    }
}
