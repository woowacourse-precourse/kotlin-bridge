package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printMessage(message: String) {
        println(message)
    }

    fun printErrorMessage(error: String) {
        println("[ERROR] $error")
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridge: List<String>, userStep: List<Boolean>) {
        val printValue = determineMap(bridge, userStep)

        for (line in 1 downTo 0) {
            print("[ ")
            printMapInner(printValue)
            println(" ]")
        }
    }

    private fun determineMap(bridge: List<String>, userStep: List<Boolean>): MutableList<MutableList<String>> {
        val printValue = mutableListOf<MutableList<String>>()
        val converter = mapOf("U" to 1, "D" to 0)

        for (index in userStep.indices) {
            val direction = converter[bridge[index]]!!
            val result = determineOX(userStep, index, direction)
            printValue.add(result)
        }
        return printValue
    }

    private fun determineOX(userStep: List<Boolean>, index: Int, direction: Int): MutableList<String> {
        val result = mutableListOf(" ", " ")
        if (userStep[index])
            result[direction] = "O"
        if (!userStep[index])
            result[1 - direction] = "X"
        return result
    }

    private fun printMapInner(printValue: MutableList<MutableList<String>>) {
        for (answerLength in printValue.indices) {
            print(printValue[answerLength][1])
            if (answerLength != printValue.size - 1)
                print(" | ")
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
