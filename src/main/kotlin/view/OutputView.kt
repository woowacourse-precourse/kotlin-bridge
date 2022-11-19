package view

import utils.Messages.ASK_GAME_REPEAT
import utils.Messages.CHECK_SUCCESS_GAME
import utils.Messages.INPUT_BRIDGE_LEN
import utils.Messages.MOVE_TARGET
import utils.Messages.NUM_TOTAL_TRIAL
import utils.Messages.RESULT_FINAL_GAME
import utils.Messages.START_BRIDGE_GAME

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private val splitter = "|"
    private val blank = " _ "
    private val emptyBlank = "   "
    private val twoPath = mutableListOf<String>("[","[")

    fun printMap(trialCount: Int, resultHashMap: MutableList<HashMap<String, String>>): MutableList<String> {
        for (i in 0 until resultHashMap.size) {
            when {
                resultHashMap[i].containsValue("X") && resultHashMap[i].contains("U") -> printUpperMap("X", trialCount, i)
                resultHashMap[i].containsValue("O") && resultHashMap[i].contains("U") -> printUpperMap("O", trialCount, i)
                resultHashMap[i].containsValue("X") && resultHashMap[i].contains("D") -> printUnderMap("X", trialCount, i)
                resultHashMap[i].containsValue("O") && resultHashMap[i].contains("D") -> printUnderMap("O", trialCount, i)
            }
        }
        twoPath[0] += "]"
        twoPath[1] += "]"
        return twoPath
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun printUpperMap(newMove: String, trialCount: Int, i: Int): MutableList<String> {
        val newBlank = blank.replace("_", newMove)
        twoPath[0] += newBlank
        twoPath[1] += emptyBlank
        if (i != (trialCount)) {
            twoPath[0] += splitter
            twoPath[1] += splitter
        }
        return twoPath
    }

    private fun printUnderMap(newMove: String, trialCount: Int, i: Int): MutableList<String> {
        val newBlank = blank.replace("_", newMove)
        twoPath[0] += emptyBlank
        twoPath[1] += newBlank
        if (i != (trialCount)) {
            twoPath[0] += splitter
            twoPath[1] += splitter
        }
        return twoPath
    }

    fun printSingleResult(resultHashMap: MutableList<HashMap<String, String>>) {
        when {
            resultHashMap[0].containsValue("X") && resultHashMap[0].contains("U") -> println("[ X ]\n[   ]")
            resultHashMap[0].containsValue("O") && resultHashMap[0].contains("U") -> println("[ O ]\n[   ]")
            resultHashMap[0].containsValue("X") && resultHashMap[0].contains("D") -> println("[   ]\n[ X ]")
            resultHashMap[0].containsValue("O") && resultHashMap[0].contains("D") -> println("[   ]\n[ O ]")
        }
    }

    fun printGameStart() {
        println(START_BRIDGE_GAME)
    }

    fun printBridgeLen() {
        println(INPUT_BRIDGE_LEN)
    }

    fun printMoveTarget() {
        println(MOVE_TARGET)
    }

    fun printAskGameResult() {
        println(ASK_GAME_REPEAT)
    }

    fun printResultFinalGame() {
        println(RESULT_FINAL_GAME)
    }

    fun printCheckSuccessGame(resultGame: String) {
        println(CHECK_SUCCESS_GAME + resultGame)
    }

    fun printNumTotalTrial(trial: Int) {
        println(NUM_TOTAL_TRIAL + "$trial")
    }
}
