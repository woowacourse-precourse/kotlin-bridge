package bridge.domain

import bridge.data.Bridge
import bridge.data.BridgeMap

const val UP = "U"
const val DOWN = "D"
const val RIGHT = "O"
const val WRONG = "X"
const val BLANK = "   "
const val PARTITION = "|"


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
        val hit = getHit(bridge, upDown)
        if (upDown == UP) {
            ifU(bridge, hit, map)
        }
        if (upDown == DOWN) {
            ifD(bridge, hit, map)
        }
        bridge.moveCurrentLocation()
        return hit
    }

    private fun getHit(bridge: Bridge, upDown: String): String {
        if (bridge.matches(upDown)) {
            return RIGHT
        }
        if (!bridge.matches(upDown)) {
            return WRONG
        }
        throw IllegalStateException()
    }

    private fun ifU(bridge: Bridge, hit: String, map: BridgeMap) {
        if (bridge.location != 0) {
            map.upSide += PARTITION
            map.downSide += PARTITION
        }
        map.upSide += " $hit "
        map.downSide += BLANK
    }

    private fun ifD(bridge: Bridge, hit: String, map: BridgeMap) {
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
