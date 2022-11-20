package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private var playerPosition = 0

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge: List<String>, playerDirection: String): GameStatus {
        var gameStatus = when (playerDirection) {
            bridge[playerPosition++] -> GameStatus.CONTINUING
            else -> GameStatus.FAILED
        }
        if (playerPosition == bridge.size && gameStatus == GameStatus.CONTINUING) {
            gameStatus = GameStatus.SUCCEEDED
        }
        return gameStatus
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        playerPosition = 0
    }

    private fun String.decideRetryOrQuit() = this == "R"

}
