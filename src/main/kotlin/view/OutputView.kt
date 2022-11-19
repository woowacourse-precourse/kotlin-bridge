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
    fun printMap(trialCount: Int, resultHashMap: MutableList<HashMap<String, String>>) : MutableList<String>{
        var moveUpperPath = "["
        var moveUnderPath = "["
        val splitter = "|"
        val blank = " _ "
        val emptyBlank = "   "
        val totalMovePath = mutableListOf<String>("","")
        for (i in 0 until resultHashMap.size) {
            when {
                resultHashMap[i].containsValue("X") && resultHashMap[i].contains("U") -> {
                    val newBlank = blank.replace("_", "X")
                    moveUpperPath += newBlank
                    moveUnderPath += emptyBlank
                    if (i != (trialCount)) {
                        moveUpperPath += splitter
                        moveUnderPath += splitter
                    }
                }
                resultHashMap[i].containsValue("O") && resultHashMap[i].contains("U") -> {
                    val newBlank = blank.replace("_", "O")
                    moveUpperPath += newBlank
                    moveUnderPath += emptyBlank
                    if (i != (trialCount)) {
                        moveUpperPath += splitter
                        moveUnderPath += splitter
                    }
                }
                resultHashMap[i].containsValue("X") && resultHashMap[i].contains("D") -> {
                    val newBlank = blank.replace("_", "X")
                    moveUnderPath += newBlank
                    moveUpperPath += emptyBlank
                    if (i != (trialCount)) {
                        moveUpperPath += splitter
                        moveUnderPath += splitter
                    }
                }
                resultHashMap[i].containsValue("O") && resultHashMap[i].contains("D") -> {
                    val newBlank = blank.replace("_", "O")
                    moveUnderPath += newBlank
                    moveUpperPath += emptyBlank
                    if (i != (trialCount)) {
                        moveUpperPath += splitter
                        moveUnderPath += splitter
                    }
                }
            }
        }
        moveUpperPath += "]"
        moveUnderPath += "]"
        totalMovePath[0] = moveUpperPath
        totalMovePath[1] = moveUnderPath
        return totalMovePath
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(trialCount: Int, resultHashMap: MutableList<HashMap<String, String>>) {
        printMap(trialCount, resultHashMap)
    }

    fun printSingleResult(resultHashMap: MutableList<HashMap<String, String>>) {
        when {
            resultHashMap[0].containsValue("X") && resultHashMap[0].contains("U") -> {
                println("[ X ]")
                println("[   ]")
            }

            resultHashMap[0].containsValue("O") && resultHashMap[0].contains("U") -> {
                println("[ O ]")
                println("[   ]")
            }

            resultHashMap[0].containsValue("X") && resultHashMap[0].contains("D") -> {
                println("[   ]")
                println("[ X ]")
            }

            resultHashMap[0].containsValue("O") && resultHashMap[0].contains("D") -> {
                println("[   ]")
                println("[ O ]")
            }
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
        println(CHECK_SUCCESS_GAME+resultGame)
    }

    fun printNumTotalTrial(trial: Int) {
        println(NUM_TOTAL_TRIAL+"$trial")
    }
}
