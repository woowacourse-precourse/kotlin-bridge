package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(
        prevBridge: MutableList<String>,
        movement: String
    ) {
        prevBridge.add(movement)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(
        command: String
    ): Boolean {
        return when (command) {
            "R" -> true
            "Q" -> false
            else -> throw java.lang.IllegalArgumentException("[ERROR] 잘못된 종료 입력입니다.")
        }
    }

    enum class GameState {
        Win, Lose, Doing
    }

    fun isDone(
        curBridge: List<String>,
        answerBridge: List<String>
    ): GameState {
        if (curBridge.last() != answerBridge[curBridge.size - 1]) return GameState.Lose
        if (curBridge.size == answerBridge.size) return GameState.Win
        return GameState.Doing
    }
}
