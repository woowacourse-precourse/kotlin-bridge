package bridge.domain

import bridge.consol.Message.BLANK
import bridge.consol.Message.DOWN
import bridge.consol.Message.PARTITION
import bridge.consol.Message.UP
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
    fun move(bridge: Bridge, upDown: String, map: BridgeMap): String {
        val hit = bridge.match(upDown)
        if (upDown == UP) {
            drawUpSide(bridge, hit, map)
        }
        if (upDown == DOWN) {
            drawDownSide(bridge, hit, map)
        }
        bridge.moveCurrentLocation()
        return hit
    }

    private fun drawUpSide(bridge: Bridge, hit: String, map: BridgeMap) {
        if (bridge.location != 0) {
            map.upSide += PARTITION
            map.downSide += PARTITION
        }
        map.upSide += " $hit "
        map.downSide += BLANK
    }

    private fun drawDownSide(bridge: Bridge, hit: String, map: BridgeMap) {
        if (bridge.location != 0) {
            map.upSide += PARTITION
            map.downSide += PARTITION
        }
        map.upSide += BLANK
        map.downSide += " $hit "
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(bridge: Bridge, bridgeMap: BridgeMap) {
        bridge.clear()
        bridgeMap.clear()
    }
}
