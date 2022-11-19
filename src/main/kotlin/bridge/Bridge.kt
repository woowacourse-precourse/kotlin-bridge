package bridge

import bridge.ex.Move

class Bridge {

    private val bridge : List<BridgeSpace>

    constructor(bridge: List<String>) {
        this.bridge = mapBridges(bridge)
    }

    fun mapBridges(bridge: List<String>) : List<BridgeSpace> =
        bridge.mapIndexed { index, s ->  BridgeSpace(BridgeDirection.valueOf(s), index)}

    fun move(input: BridgeDirection, bridgeMap: List<String>, idx: Int) {
        val mark = movePossibleMark(movePossible(input, bridgeMap, idx))
        bridgeResult.setMoveResult(input, mark)
    }

    fun movePossible(bridgeSpace: BridgeSpace) : Move {
        bridge.filterNot { it.matchBridgeSpace(bridgeSpace).equals(Move.IMPOSSIBLE) }
            .forEach { return it.matchBridgeSpace(bridgeSpace) }
        return Move.IMPOSSIBLE
    }

    fun getGameResult(): Int = success

    fun getUpBridgeResult(): String = bridgeResult.upBridgeResult()

    fun getDownBridgeResult(): String = bridgeResult.downBridgeResult()


    companion object {
        const val MOVE_POSSIBLE_MARK = "O"
        const val MOVE_IMPOSSIBLE_MARK = "X"
    }
}