package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(bridgeMaker: BridgeMaker, bridgeSize: Int) {
    val bridge: List<String> = bridgeMaker.makeBridge(bridgeSize)
    val userChoice: MutableList<String> = mutableListOf()
    var trial = 1

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(choice: String): Boolean {
        userChoice.add(choice)
        return isGameEnd()
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        userChoice.clear()
        trial++
    }

    fun isSuccess(): Boolean = bridge == userChoice

    private fun isGameEnd(): Boolean {
        if (userChoice.size == bridge.size) return true
        if (userChoice.last() != bridge[userChoice.size - 1]) return true
        return false
    }
}
