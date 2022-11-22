package bridge.view

import bridge.resources.makeNewRoute
import bridge.resources.setCloseRoute
import bridge.resources.updateNotSelectedRoute
import bridge.resources.updateSelectedRoute
import bridge.resources.*

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    private val topLineRoute: StringBuilder = StringBuilder()
    private val bottomLineRoute: StringBuilder = StringBuilder()

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(movedList: List<String>, isLastMoveSuccess: Boolean) {
        makeMap(movedList, isLastMoveSuccess)
        println(topLineRoute.toString())
        println(bottomLineRoute.toString())
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(isSuccess: Boolean, tryCount: Int, userSelectedRoute: List<String>) {
        println(OUTPUT_RESULT_GAME_TITLE)
        printMap(userSelectedRoute, isSuccess)
        println(OUTPUT_RESULT_GAME_IS_SUCCESS.format(if (isSuccess) OUTPUT_RESULT_GAME_SUCCESS else OUTPUT_RESULT_GAME_FAIL))
        println(OUTPUT_RESULT_GAME_RETRY_COUNT.format(tryCount))
    }

    fun printStartGameGuide() = println(OUTPUT_START_GAME)

    private fun makeMap(movedList: List<String>, isLastMoveSuccess: Boolean) {
        topLineRoute.makeNewRoute()
        bottomLineRoute.makeNewRoute()
        for ((index, currentLine) in movedList.withIndex())
            updateMap(currentLine, if (index == movedList.lastIndex) isLastMoveSuccess else true)

        topLineRoute.setCloseRoute()
        bottomLineRoute.setCloseRoute()
    }

    private fun updateMap(selectedLine: String, isLastMoveSuccess: Boolean) {
        (if (selectedLine == BRIDGE_TOP_LINE_CHAR) topLineRoute else bottomLineRoute).updateSelectedRoute(
            isLastMoveSuccess
        )
        (if (selectedLine != BRIDGE_TOP_LINE_CHAR) topLineRoute else bottomLineRoute).updateNotSelectedRoute()
    }
}
