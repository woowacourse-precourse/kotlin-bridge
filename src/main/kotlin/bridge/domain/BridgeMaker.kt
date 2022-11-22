package bridge.domain

import bridge.BridgeNumberGenerator
import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_LOWER_INCLUSIVE
import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_UPPER_INCLUSIVE
import bridge.resources.*

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        val bridgeNumberList = mutableListOf<String>()
        for (i in 0 until size)
            bridgeNumberList.add(convertRandomNumberToChar(getRandomNumber()))
        return bridgeNumberList
    }

    private fun getRandomNumber() = bridgeNumberGenerator.generate()
    private fun convertRandomNumberToChar(randomNumber: Int): String {
        require(randomNumber == RANDOM_UPPER_INCLUSIVE || randomNumber == RANDOM_LOWER_INCLUSIVE) { ERROR_INPUT_VALUE_0_1_ONLY }
        if (randomNumber == RANDOM_UPPER_INCLUSIVE)
            return BRIDGE_TOP_LINE_CHAR
        if (randomNumber == RANDOM_LOWER_INCLUSIVE)
            return BRIDGE_BOTTOM_LINE_CHAR

        throw IllegalArgumentException(ERROR_INPUT_VALUE_0_1_ONLY)
    }
}
