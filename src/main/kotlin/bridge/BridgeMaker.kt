package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        var bridge = listOf<String>()
        for (eachStage in 0 until size) bridge.plus(BridgeType.convertNumberCodeToStringCode(bridgeNumberGenerator.generate()))
        return bridge
    }
}
