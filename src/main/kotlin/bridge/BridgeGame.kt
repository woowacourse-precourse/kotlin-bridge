package bridge

import bridge.constants.CORRECT_ANSWER
import bridge.constants.WRONG_ANSWER

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridge: String, moveDirection: String): Boolean {
        if (bridge == moveDirection)
            return true
        return false
    }

    fun determineMap(bridge: List<String>, userStep: List<Boolean>): MutableList<MutableList<String>> {
        val printValue = mutableListOf<MutableList<String>>()
        val converter = mapOf("U" to 1, "D" to 0)
        for (index in userStep.indices) {
            val direction = converter[bridge[index]]!!
            val result = determineOX(userStep[index], direction)
            printValue.add(result)
        }
        return printValue
    }

    private fun determineOX(userAnswer: Boolean, direction: Int): MutableList<String> {
        val result = mutableListOf(" ", " ")
        if (userAnswer) {
            result[direction] = CORRECT_ANSWER
            return result
        }
        result[1 - direction] = WRONG_ANSWER
        return result
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(command: String): Boolean {
        if (command == "Q")
            return false
        return true
    }
}
