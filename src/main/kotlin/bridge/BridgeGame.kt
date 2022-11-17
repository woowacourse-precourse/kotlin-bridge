package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
enum class BridgeGame(private var isStarted: Boolean = true) {
    MOVE, RETRY, NOW_STATE_MESSAGE;

    private var responseMessage: String = BridgeGameMessages.GUID_GAME_START_MESSAGE

    fun isStarted(): Boolean {
        return isStarted
    }

    fun turnOff() {
        isStarted = false
    }

    fun turnOn() {
        isStarted = true
    }

    fun respondToRequest(request: BridgeGame): String {
        return when (request) {
            NOW_STATE_MESSAGE -> responseMessage
            else -> throw IllegalArgumentException()
        }
    }

    fun acceptRequest(request: BridgeGame) { // 변경 요청
        return when (request) {
            RETRY -> updateWithRetry()
            else -> throw IllegalArgumentException()
        }
    }

    fun acceptRequest(request: BridgeGame, how: String) { // 변경 요청
        return when (request) {
            MOVE -> updateWithMove(how)
            else -> throw IllegalArgumentException()
        }
    }

    private fun updateWithMove(how: String) {

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun move(how: String) {

    }

    private fun updateWithRetry() {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun retry() {

    }

    private fun updateState(string: String) {

    }
}
