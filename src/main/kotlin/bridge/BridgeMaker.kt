package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        // 다리의 정보를 담을 리스트
        val bridge: MutableList<String> = mutableListOf()
        // 윗 칸을 건널 수 있는 경우 1 (U), 아랫칸을 건널 수 있는 경우 0 (D)
        for ( i in 0..size-1) {
            if ( bridgeNumberGenerator.generate() == 0 ) bridge.add("D")
            else bridge.add("U")
        }
        return bridge
    }
}
