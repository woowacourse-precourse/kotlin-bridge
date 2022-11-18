package bridge

import bridge.model.Direction

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val directionNames = mutableListOf<String>()
        repeat(size) {
            val value = bridgeNumberGenerator.generate()
            val direction = Direction.getByValue(value)
            directionNames.add(direction.toString())
        }
        return directionNames
    }
}
