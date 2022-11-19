package bridge.domain

import bridge.data.Bridge
import bridge.data.BridgeMap

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
    fun move(bridge: Bridge, upDown: String, map: BridgeMap) :String{
        var hit = ""
        if (bridge.matches(upDown)) {
            hit = "O"
        }
        if (!bridge.matches(upDown)) {
            hit = "X"
        }
        if (upDown == "U") {
            ifU(bridge, hit, map)
        }
        if (upDown == "D") {
            ifD(bridge, hit, map)
        }
        bridge.moveCurrentLocation()
        return  hit
    }

    private fun ifU(bridge: Bridge, hit: String, map: BridgeMap) {
        if (bridge.currentLocation != 0) {
            map.upSide += "|"
            map.downSide += "|"
        }
        map.upSide += " $hit "
        map.downSide += "   "
    }

    private fun ifD(bridge: Bridge, hit: String, map: BridgeMap) {
        if (bridge.currentLocation != 0) {
            map.upSide += "|"
            map.downSide += "|"
        }
        map.upSide += "   "
        map.downSide += " $hit "
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(bridge: Bridge,bridgeMap: BridgeMap) {
        bridge.clear()
        bridgeMap.clear()

    }
}
