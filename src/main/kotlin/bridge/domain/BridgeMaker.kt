package bridge.domain

import bridge.util.NUMBER_ONE
import bridge.util.UP
import bridge.util.DOWN

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        return List(size) {
            val number = bridgeNumberGenerator.generate()
            convertNumberToString(number)
        }
    }

    // 숫자에 해당하는 문자로 반환
    private fun convertNumberToString(number: Int): String {
        return if (number == NUMBER_ONE) UP else DOWN
    }
}
