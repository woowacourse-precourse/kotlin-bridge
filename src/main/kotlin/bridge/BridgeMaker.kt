package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        var randomNumber: Int
        val bridge = mutableListOf<String>()
        repeat(size) {
            randomNumber = bridgeNumberGenerator.generate()
            if (randomNumber == ZERO) bridge.add(DOWN)
            else bridge.add(UP)
        }
        return bridge
    }
}
