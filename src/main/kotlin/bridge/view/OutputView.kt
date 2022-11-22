package bridge.view

import bridge.util.FINAL_GAME_RESULT_MESSAGE
import bridge.util.GAME_WHETHER_MESSAGE
import bridge.util.TOTAL_TRIAL_MESSAGE

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printMap(bridge: List<String>) {
        bridge.forEach { currentMap -> print(currentMap) }
    }

    fun printResult(bridge: List<String>, trialCount: Int, whether: String) {
        println(FINAL_GAME_RESULT_MESSAGE)
        printMap(bridge)
        println(GAME_WHETHER_MESSAGE + whether)
        println(TOTAL_TRIAL_MESSAGE + trialCount)
    }
}

