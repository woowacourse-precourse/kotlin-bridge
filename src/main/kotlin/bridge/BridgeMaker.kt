package bridge
import bridge.model.Bridge
import bridge.utils.Constants.UP_SYMBOL
import bridge.utils.Constants.DOWN_SYMBOL
/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        return makeBridgeLane(size)
    }

    /**
     * 다리 칸을 만드는 함수
     */
    private fun makeBridgeLane(size: Int): List<String>{
        val bridgeLane = mutableListOf<String>()
        for (index in 0 until size){
            when (bridgeNumberGenerator.generate()) {
                1 -> bridgeLane.add("U")
                0 -> bridgeLane.add("D")
            }
        }
        return bridgeLane
    }
}



