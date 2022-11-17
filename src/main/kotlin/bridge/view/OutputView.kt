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
    fun printMap(bridge: List<String>, moved: Int, answer: Boolean) {
        printSign(bridge, moved, UP)
        printAnswer(answer, bridge[moved], UP)
        println(END_BRACKET)

        printSign(bridge, moved, DOWN)
        printAnswer(answer, bridge[moved], DOWN)
        println(END_BRACKET)
    }

    fun printSign(bridge: List<String>, moved: Int, line: String) {
        print(START_BRACKET)
        for (idx in 0 until moved) {
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
    fun printResult(bridge: List<String>, answer: Boolean) {
        println(END_GAME)
        printMap(bridge, bridge.size - 1, answer)
    }
}
