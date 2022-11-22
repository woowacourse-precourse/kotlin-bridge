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
        // 윗 줄 출력
        printSign(bridge, UP)                       // 다리 틀 출력
        printAnswer(answer, bridge.last(), UP)      // 마지막 부분의 정답 유무 출력
        println(END_BRACKET)                        // "]"
        // 아랫 줄 출력
        printSign(bridge, DOWN)
        printAnswer(answer, bridge.last(), DOWN)
        println(END_BRACKET)
    }

    private fun printSign(bridge: List<String>, line: String) {
        val maxLocation = bridge.size - SHIFT       // size - 2
        print(START_BRACKET)                            // "["
        for (idx in START_LOCATION..maxLocation) {
            if (bridge[idx] == line) print(ANSWER)      // "O"
            else print(SPACING)                         // " "
            print(SEPARATOR)                            // " | "
        }
    }

    // 정답 체크
    private fun printAnswer(answer: Boolean, locationAnswer: String, line: String) {
        if (answer && locationAnswer == line) print(ANSWER)           // 마지막이 정답이면 O
        if (!answer && locationAnswer != line) print(NOT_ANSWER)      // 정답이 아니면 X

        if (answer && locationAnswer != line) print(SPACING)          // 공백 출력
        if (!answer && locationAnswer == line) print(SPACING)         // 공백 출력
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridge: List<String>, answer: Boolean, retry: Int) {
        println(GAME_END)
        printMap(bridge, answer)
        if (answer) println(GAME_RESULT_WIN)
        else println(GAME_RESULT_LOSE)
        println(GAME_TRY_COUNT.format(retry))
    }
}
