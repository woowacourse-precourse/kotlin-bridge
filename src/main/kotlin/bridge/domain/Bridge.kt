package bridge.domain

import bridge.BridgeMaker
import bridge.BridgeNumberGenerator
import bridge.util.Constant.LOAD_GO
import bridge.util.Constant.LOAD_STOP

/**
 * 다리 도메인 VO 역할
 */
class Bridge(private val bridgeNumberGenerator: BridgeNumberGenerator, private val inputSize: Int) {
    private var map: List<String>

    init {
        val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
        map = bridgeMaker.makeBridge(inputSize)
    }

    fun cross(index: Int, move: String): String {
        return when(map[index]) {
            move -> LOAD_GO
            else -> LOAD_STOP
        }
    }

    fun crossedAll(record: MutableList<String>): Boolean {
        return record == map
    }

    fun doNotCross(player: String, position: Int): Boolean {
        return map[position] != player
    }

}
