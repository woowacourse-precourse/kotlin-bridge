package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        for (i in 1 until size+1) {
            val generatedNumber = bridgeNumberGenerator.generate()
            bridge.add(if (generatedNumber == 0) "D" else "U")
        }
        return bridge
    }
}
