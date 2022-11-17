package bridge.presentation

import bridge.domain.Result
import bridge.util.GAME_START_MESSAGE
import bridge.util.GAME_SUCCESS_OR_FAIL_MESSAGE
import bridge.util.TRIAL_COUNT_MESSAGE

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {}

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(gameResult: Result, trial: Int) {
        printSuccessOrFail(gameResult)
        printTrialCount(trial)
    }

    fun printGameStart() {
        println(GAME_START_MESSAGE + "\n")
    }

    private fun printSuccessOrFail(gameResult: Result) {
        val resultMessage = gameResult.message
        println(GAME_SUCCESS_OR_FAIL_MESSAGE.format(resultMessage))
    }

    private fun printTrialCount(trial: Int) {
        print(TRIAL_COUNT_MESSAGE.format(trial))
    }
}
