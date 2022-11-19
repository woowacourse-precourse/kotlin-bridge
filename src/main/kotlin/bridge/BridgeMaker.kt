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
        val bridgeMap = mutableListOf<String>()
        // todo as 안써도 되면 안쓰기 근데 아마 써야하지 않을까?
        // bridgeNumberGenerator as BridgeRandomNumberGenerator

        // todo size만큼 반복하는 건 좀 더 간단한 반복문이 있지 않을까?
        for(i in 0 until size) {
            val direction = bridgeNumberGenerator.generate()
            // todo 이거 리팩터 가능할 듯?
            if(direction == 0)
                bridgeMap.add("D")
            else
                bridgeMap.add("U")
        }

        return bridgeMap
    }
}
