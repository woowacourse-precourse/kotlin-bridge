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
        var bridgeNumber: MutableList<String> = mutableListOf()
        for (i: Int in 0 until size) {
            bridgeNumber = makeRandom(bridgeNumber)
        }
        return bridgeNumber
    }

    private fun makeRandom(bridgeNumber: MutableList<String>): MutableList<String> {
        val number = bridgeNumberGenerator.generate()
        if (number == BridgeRandomNumberGenerator.RANDOM_UPPER_INCLUSIVE) {
            bridgeNumber.add(UP)
        } else if (number == BridgeRandomNumberGenerator.RANDOM_LOWER_INCLUSIVE) {
            bridgeNumber.add(DOWN)
        }
        return bridgeNumber
    }
}
