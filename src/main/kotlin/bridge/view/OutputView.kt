package bridge.view

import bridge.resources.*

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridge: List<String>, answer: Boolean) {
        printSign(bridge, UP)
        printUpAnswer(answer, bridge.last())
        println(END_BRACKET)

        printSign(bridge, DOWN)
        printDownAnswer(answer, bridge.last())
        println(END_BRACKET)
    }

    private fun printSign(bridge: List<String>, line: String) {
        print(START_BRACKET)
        for (idx in 0..bridge.size - 2) {
            if (bridge[idx] == line) print(ANSWER)
            else print(SPACING)
            print(SEPARATOR)
        }
    }

    private fun printUpAnswer(answer: Boolean, locationAnswer: String) {
        if (answer && locationAnswer == UP) print(ANSWER)
        if (!answer && locationAnswer == DOWN) print(NOT_ANSWER)

        if (answer && locationAnswer == DOWN) print(SPACING)
        if (!answer && locationAnswer == UP) print(SPACING)
    }

    private fun printDownAnswer(answer: Boolean, locationAnswer: String) {
        if (answer && locationAnswer == DOWN) print(ANSWER)
        if (!answer && locationAnswer == UP) print(NOT_ANSWER)

        if (answer && locationAnswer == UP) print(SPACING)
        if (!answer && locationAnswer == DOWN) print(SPACING)
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridge: List<String>, answer: Boolean, retry: Int) {
        println(END_GAME)
        printMap(bridge, answer)
        if (answer) println(GAME_RESULT_WIN)
        if (!answer) println(GAME_RESULT_LOSE)
        println(GAME_TRY_COUNT.format(retry))
    }
}
