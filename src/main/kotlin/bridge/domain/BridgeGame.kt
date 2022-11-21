package bridge.domain

import bridge.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 * BridgeGame에 필드를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가하거나 변경 할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 */
class BridgeGame {

    val userBridge = mutableListOf<String>()

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(moveDirection: String, bridge: List<String>): Boolean {
        val compareBridgeResult = compareBridge(bridge)
        userBridge.add(moveDirection)
        OutputView().printMap(compareBridgeResult)
        return checkBridgeResult(compareBridgeResult)
    }

    private fun checkBridgeResult(compareBridgeResult: List<Pair<String, Boolean>>): Boolean {
        for (i in compareBridgeResult) {
            if (!i.second)
                return false
        }
        return true
    }

    private fun compareBridge(bridge: List<String>): List<Pair<String, Boolean>> {
        val compareBridgeResult = mutableListOf<Pair<String, Boolean>>()
        for (userIndex in 0 until userBridge.size) {
            if (bridge[userIndex] == userBridge[userIndex])
                compareBridgeResult.add(Pair(userBridge[userIndex], true))
            else
                compareBridgeResult.add(Pair(userBridge[userIndex], false))
        }
        return compareBridgeResult
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
