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
    fun move() {}

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
class BridgeGame(private val bridge: List<String>) {
    var playerBridge = mutableListOf<String>()
    var resultUpBridge = mutableListOf<String>()
    var resultDownBridge = mutableListOf<String>()
    var playCount = 0

    fun move(moving: String) {
        playerBridge.add(moving)
        if (moving == "U") {
            updateUpBridge(moving)
        }
        if (moving == "D") {
            updateDownBridge(moving)
        }
    }

    private fun updateUpBridge(moving: String) {
        if (bridge[playerBridge.size -1] == moving) {
            resultUpBridge.add("O")
        }
        else {
            resultUpBridge.add("X")
        }
    }

    private fun updateDownBridge(moving: String) {
        if (bridge[playerBridge.size -1] == moving) {
            resultDownBridge.add("O")
        }
        else {
            resultDownBridge.add("X")
        }
    }

}
