package bridge.game

import bridge.io.InputView
import bridge.io.OutputView
import bridge.resources.CORRECT
import bridge.resources.DOWN
import bridge.resources.UP
import bridge.resources.WRONG

class Bridge(
    private val way: MutableList<String>,
    private val input: InputView,
    private val output: OutputView
) {

    fun choiceStep() {
        val choice = input.readMoving()
        way.add(choice)
    }

    fun move(answerWay: List<String>): Boolean {
        output.printMap(makeTopRow(answerWay), makeBotRow(answerWay))
        return isSafeZone(answerWay)

    }

    fun makeTopRow(answerWay: List<String>): List<String> {  //윗줄 출력 양식 만들기
        val line = mutableListOf<String>()
        for (step in way.indices) {
            if (way[step] == UP) line.add(compare(answerWay[step], way[step]))

            if (way[step] == DOWN) line.add(" ")
        }
        return line
    }

    fun makeBotRow(answerWay: List<String>): List<String> { // 아랫줄 출력 양식 만들기
        val line = mutableListOf<String>()
        for (step in way.indices) {
            if (way[step] == DOWN) line.add(compare(answerWay[step], way[step]))

            if (way[step] == UP) line.add(" ")
        }
        return line
    }

    /**
     * 비교 후 O X 반환
     */
    private fun compare(answerStep: String, myStep: String): String {
        if (answerStep == myStep) {
            return CORRECT
        }
        return WRONG
    }

    /**
     * 올바른 길인지 판단
     */
    private fun isSafeZone(answerWay: List<String>): Boolean {
        for (step in way.indices) {
            if (answerWay[step] != way[step]) {
                return false
            }
        }
        return true
    }

    fun showResult(answerWay: List<String>, success: String, tryCount: Int) {
        output.printResultTitle()
        move(answerWay)
        output.printResultStatus(success, tryCount)
    }

    fun getMyWaySize(): Int {
        return way.size
    }

    fun sendGameCommand(): Boolean {
        return input.readGameCommand()
    }

    fun clearBridge() {
        way.clear()
    }

}