package bridge

import bridge.ex.Bridges
import bridge.ex.BridgesResult

class Bridge {

    private val bridge : List<BridgeSpace>

    constructor(bridge: List<String>) {
        this.bridge = mapBridges(bridge)
    }

    fun mapBridges(bridge: List<String>) : List<BridgeSpace> =
        bridge.mapIndexed { index, s ->  BridgeSpace(BridgeDirection.valueOf(s), index)}

    fun move(bridge: List<String>) : BridgeResult {
        val userBridge = Bridge(bridge)
        val bridgeResult = BridgeResult(this.bridge.size)

        this.bridge.forEach {
            val movePossible = userBridge.movePossible(it)
            bridgeResult.setMoveResult(it.getDirection(), movePossible)
        }
        return bridgeResult
    }

    fun movePossible(bridgeSpace: BridgeSpace) : Move {
        bridge.filterNot { it.matchBridgeSpace(bridgeSpace).equals(Move.IMPOSSIBLE) }
            .forEach { return it.matchBridgeSpace(bridgeSpace) }
        return Move.IMPOSSIBLE
    }
}