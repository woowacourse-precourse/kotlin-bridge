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
        for (i in 1..size) {
            bridge.add(makeOneColumn())
        }
        return bridge
    }

    private fun makeOneColumn(): String {
        val bridgeNumberGenerator = bridgeNumberGenerator.generate()
        return if (bridgeNumberGenerator == RANDOM_LOWER_INCLUSIVE) "UD" else "DU"
    }

    companion object {
        const val RANDOM_LOWER_INCLUSIVE = 0
        const val RANDOM_UPPER_INCLUSIVE = 1
    }
}
