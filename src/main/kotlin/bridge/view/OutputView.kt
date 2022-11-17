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
    fun printMap(bridge: List<String>, location: Int, answer: Boolean) {
        printSign(bridge, location, UP)
        printAnswer(answer, bridge[location], UP)
        println(END_BRACKET)

        printSign(bridge, location, DOWN)
        printAnswer(answer, bridge[location], DOWN)
        println(END_BRACKET)
    }

    fun printSign(bridge: List<String>, location: Int, line: String) {
        print(START_BRACKET)
        for (idx in 0 until location) {
            if (bridge[idx] == line) print(ANSWER)
            else print(SPACING)
            print(SEPARATOR)
        }
    }

    fun printAnswer(answer: Boolean, space: String, line: String) {
        if (space == UP) { // space가 UP이면 윗줄, DOWN이면 아랫줄
            if (answer && line == UP) print(ANSWER) // 정답인 경우 O 출력
            if (answer && line == DOWN) print(SPACING) // 반대줄에는 공백 출력
            if (!answer && line == DOWN) print(NOT_ANSWER)
            if (!answer && line == UP) print(SPACING)
        } else {
            if (answer && line == DOWN) print(ANSWER)
            if (!answer && line == DOWN) print(SPACING)
            if (!answer && line == UP) print(NOT_ANSWER)
            if (answer && line == UP) print(SPACING)
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridge: List<String>, location: Int, answer: Boolean) {
        println(END_GAME)
        printMap(bridge, location, answer)
    }

    fun printEnd(answer: Boolean, retry: Int) {
        if (answer) println(GAME_RESULT_WIN)
        if (!answer) println(GAME_RESULT_LOSE)
        println(GAME_TRY_COUNT.format(retry))
    }
}
