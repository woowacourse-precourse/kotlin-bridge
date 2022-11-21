package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        var bridge = mutableListOf<String>()
        for(i in 0 until size){
            val randomNum = bridgeNumberGenerator.generate()
            if(randomNum == 0){
                bridge.add("D")
                continue
            }
            bridge.add("U")
        }
        return bridge
    }
}
