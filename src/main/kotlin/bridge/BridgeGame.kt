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
    fun move(bridge: Bridge, upDown: String) {
        var hit = ""
        if (bridge.matches(upDown)) {
            hit = "O"
        }
        if (!bridge.matches(upDown)) {
            hit = "X"
        }
        if (upDown == "U") {
            ifU(bridge, hit)
        }
        if (upDown == "D") {
           ifD(bridge, hit)
        }
        bridge.setHit(hit)
        bridge.moveCurrentLocation()
    }

    private fun ifU(bridge: Bridge, hit: String){
        if (bridge.currentLocation != 0) {
            bridge.upBridge += "|"
            bridge.downBridge += "|"
        }
        bridge.upBridge += " $hit "
        bridge.downBridge += "   "
    }

    private fun ifD(bridge: Bridge, hit: String) {
        if (bridge.currentLocation != 0) {
            bridge.upBridge += "|"
            bridge.downBridge += "|"
        }
        bridge.upBridge += "   "
        bridge.downBridge += " $hit "
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(bridge: Bridge) {
        bridge.clear()

    }
}
