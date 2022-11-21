package bridge

import bridge.constants.*

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printMessage(message: String) {
        println(message)
    }

    fun printMessage(message1: String, message2: String) {
        println(message1)
        println(message2)
    }

    fun printErrorMessage(error: String) {
        println("[ERROR] $error")
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(printValue: MutableList<MutableList<String>>) {
        for (line in 1 downTo 0) {
            print(MapPrint.START.symbol)
            printMapInner(printValue, line)
            println(MapPrint.END.symbol)
        }
        println()
    }

    private fun printMapInner(printValue: MutableList<MutableList<String>>, line: Int) {
        for (answerLength in printValue.indices) {
            print(printValue[answerLength][line])
            if (answerLength != printValue.size - 1)
                print(MapPrint.SEPARATOR.symbol)
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(printValue: MutableList<MutableList<String>>, userStep: List<Boolean>, count: Int) {
        printMessage(RESULT_MESSAGE)
        printMap(printValue)
        val converter = mapOf(true to SUCCESS, false to FAIL)
        println(RESULT_SUCCESS_OR_FAIL + converter[userStep.last()])
        println(RESULT_TRY_COUNT + count)
    }
}
