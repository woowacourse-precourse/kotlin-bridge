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
        val bridge = mutableListOf<String>()
        repeat(size) {
            bridge.add(inputUpDown(bridgeNumberGenerator.generate()))
        }
        return bridge
    }

    private fun inputUpDown(number: Int): String {
        return if (number == BridgeRandomNumberGenerator.RANDOM_UPPER_INCLUSIVE) {
            UP_STAIR
        } else {
            DOWN_STAIR
        }
    }

    companion object {
        const val UP_STAIR = "U"
        const val DOWN_STAIR = "D"
    }
}
