package bridge.domain

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

private enum class Bridge(val message: String) {
    RIGHT_ANSWER("O"),
    WRONG_ANSWER("X"),
    NOT_SELECT(" ")
}

class BridgeGame(private var bridge: List<String>) {

    private val upMapResult = mutableListOf<String>()
    private val downMapResult = mutableListOf<String>()

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun move() {}

    private fun checkMovable(moving: String, step: Int): Boolean {
        if (moving == bridge[step]) {
            return true
        }
        return false
    }

    private fun moveUpMap(movable: Boolean) {
        val addValue = if (movable) Bridge.RIGHT_ANSWER.message else Bridge.WRONG_ANSWER.message
        upMapResult.add(addValue)
        downMapResult.add(Bridge.NOT_SELECT.message)
    }

    private fun moveDownMap(movable: Boolean) {
        val addValue = if (movable) Bridge.RIGHT_ANSWER.message else Bridge.WRONG_ANSWER.message
        upMapResult.add(Bridge.NOT_SELECT.message)
        downMapResult.add(addValue)
    }

    fun getMapResult(): Pair<List<String>, List<String>> {
        return Pair(upMapResult, downMapResult)
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
