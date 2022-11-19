package bridge.presentation

import bridge.controller.game.Result
import bridge.domain.map.Mark
import bridge.util.*
import bridge.util.constant.*

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(route: List<List<Mark>>) {
        route.forEach { subRoute ->
            println(subRoute.convertAsBridgeRoute())
        }
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(gameResult: Result, trial: Int, route: List<List<Mark>>) {
        println(GAME_FINISH_MESSAGE)
        printMap(route)
        printSuccessOrFail(gameResult)
        printTrialCount(trial)
    }

    fun printStartMessage() {
        println(GAME_START_MESSAGE)
    }

    fun printBridgeLengthQuestion() {
        println(BRIDGE_LENGTH_QUESTION_MESSAGE)
    }

    fun printDirectionQuestion() {
        println(DIRECTION_QUESTION_MESSAGE)
    }

    fun printRetryQuestion() {
        println(GAME_RETRY_QUESTION_MESSAGE)
    }

    private fun printSuccessOrFail(gameResult: Result) {
        val resultMessage = gameResult.message
        println(GAME_SUCCESS_OR_FAIL_MESSAGE.format(resultMessage))
    }

    private fun printTrialCount(trial: Int) {
        print(TRIAL_COUNT_MESSAGE.format(trial))
    }

    fun printError(throwable: Throwable) {
        println(throwable.message)
    }
}