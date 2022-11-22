package bridge.ui

import bridge.domain.data.BridgeKeyword
import bridge.domain.data.BridgeOutputText
import bridge.domain.data.MovingResultData
import bridge.domain.usecase.BridgeGame
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridge: List<String>): Pair<MovingResultData, Int> {
        var bridgeGameLoop = true
        var totalNumberOfChallenges = 0
        var movingResult = MovingResultData()
        while (bridgeGameLoop) {
            movingResult = getMovingResult(bridge)
            bridgeGameLoop = movingResult.loop
            totalNumberOfChallenges++
        }
        return Pair(movingResult, totalNumberOfChallenges)
    }
    private fun getMovingResult(bridge: List<String>): MovingResultData {
        var upRowsResult = ""
        var downRowsResult = ""
        bridge.mapIndexed { index, bridgeColumn ->
            val userInputRow = InputView().readMoving()
            upRowsResult += getUpRowsResult(index, bridgeColumn, userInputRow)
            downRowsResult += getDownRowsResult(index, bridgeColumn, userInputRow)
            printRowsResult(upRowsResult, downRowsResult)
            if (isNotPassableInRows(upRowsResult, downRowsResult)) return bridgeGameRetry(upRowsResult, downRowsResult)
        }
        return MovingResultData(upRowsResult, downRowsResult, false)
    }

    private fun getUpRowsResult(bridgeIndex: Int, bridgeRows: String, userInputRow: String) =
        "${getLineOrBlank(bridgeIndex)}${BridgeGame().move(bridgeRows, userInputRow).first}"

    private fun getDownRowsResult(bridgeIndex: Int, bridgeRows: String, userInputRow: String) =
        "${getLineOrBlank(bridgeIndex)}${BridgeGame().move(bridgeRows, userInputRow).second}"
    private fun getLineOrBlank(bridgeIndex: Int): String {
        if (bridgeIndex > 0) return " | "
        return ""
    }
    private fun printRowsResult(upRowsResult: String, downRowsResult: String) {
        println("[ $upRowsResult ]")
        println("[ $downRowsResult ]\n")
    }

    private fun isNotPassableInRows(upRowsResult: String, downRowsResult: String): Boolean {
        return upRowsResult.contains(BridgeKeyword.FAIL.keyword) || downRowsResult.contains(BridgeKeyword.FAIL.keyword)
    }

    private fun bridgeGameRetry(upRowsResult: String, downRowsResult: String): MovingResultData {
        val userInputGameCommand = InputView().readGameCommand()
        return BridgeGame().retry(upRowsResult, downRowsResult, userInputGameCommand)
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(upRowsResult: String, downRowsResult: String, gameCount: Int) {
        println(BridgeOutputText.FINAL_RESULT.text)
        println("[ $upRowsResult ]")
        println("[ $downRowsResult ]\n")
        if (isNotPassableInRows(upRowsResult, downRowsResult)) println(BridgeOutputText.FAIL_TEXT.text)
        else println(BridgeOutputText.SUCCESS_TEXT.text)
        println("${BridgeOutputText.TOTAL_CHALLENGE.text}$gameCount")
    }
}
