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
    fun move(move: String): Boolean {
        if (move == BridgeMaker.bridge[order]) {
            moveSuccess(BridgeMaker.bridge)
            return true
        }
        if (move != BridgeMaker.bridge[order]) {
            moveFail(BridgeMaker.bridge)
            return false
        }
        return false
    }

    fun discriminateEnd(bridge: List<String>) {
        val size = bridge.size
        if (order == size - 1) {
            endGame = true
            result = success
        }
        if (order != size - 1)
            order++
    }

    fun moveSuccess(bridge: List<String>) {
        if (bridge[order] == "U") {
            upBridge.add("O")
            downBridge.add(" ")
        }
        if (bridge[order] == "D") {
            upBridge.add(" ")
            downBridge.add("O")
        }
    }

    fun moveFail(bridge: List<String>) {
        if (bridge[order] == "U") {
            upBridge.add(" ")
            downBridge.add("X")
        }
        if (bridge[order] == "D") {
            upBridge.add("X")
            downBridge.add(" ")
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(answer: String) {
        if (answer == "Q") {
            endGame = true
        }
        if (answer == "R") {
            reset()
        }
    }

    fun reset() {
        tryCount++
        order = 0
        upBridge.clear()
        downBridge.clear()
    }

    //TODO 객체 활용
    companion object {
        var upBridge = mutableListOf<String>()
        var downBridge = mutableListOf<String>()
        const val success = true
    }
}
