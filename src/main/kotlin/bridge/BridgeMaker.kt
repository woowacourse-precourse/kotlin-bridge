package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
const val DOWN_BRIDGE = 0
const val UP_BRIDGE = 1

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        val list = mutableListOf<String>()
        repeat(size) {
            when (bridgeNumberGenerator.generate()) {
                DOWN_BRIDGE -> list.add("D")
                UP_BRIDGE -> list.add("U")
            }
        }
        return list
    }
}
