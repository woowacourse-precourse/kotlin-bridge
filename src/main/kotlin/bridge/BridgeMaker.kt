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
        return listOf(makeBridgeUpperShape(size), makeBridgeLowerShape(size))
    }

    /**
     * 위쪽의 다리 형태를 만드는 함수
     */
    fun makeBridgeUpperShape(size: Int): String{
        var bridgeUpperShape = ""
        for (index in 0 until size){
            when (bridgeNumberGenerator.generate()) {
                1 -> bridgeUpperShape += " U "
                0 -> bridgeUpperShape += "   "
            }
            if (index != size-1)
                bridgeUpperShape += "|"
        }
        return bridgeUpperShape
    }

    /**
     * 아래쪽의 다리 형태를 만드는 함수
     */
    fun makeBridgeLowerShape(size: Int): String{
        var bridgeLowerShape = ""
        for (index in 0 until size){
            when (bridgeNumberGenerator.generate()) {
                1 -> bridgeLowerShape += " D "
                0 -> bridgeLowerShape += "   "
            }
            if (index != size-1)
                bridgeLowerShape += "|"
        }
        return bridgeLowerShape
    }
}


