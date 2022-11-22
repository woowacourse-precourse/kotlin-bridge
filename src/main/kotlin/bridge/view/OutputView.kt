package bridge.view

import bridge.common.GameResult
import bridge.common.GameState

private const val BRIDGE_START = "[ "
private const val BRIDGE_END = " ]"
private const val DIVISION_LINE = " | "

private const val GAME_START = "다리 건너기 게임을 시작합니다."
private const val ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
private const val SELECT_UP_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
private const val ENTER_RETRY_END = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
private const val FINAL_RESULT = "최종 게임 결과"
private const val TOTAL_TRY_COUNT = "총 시도한 횟수: "

private const val WRONG_GAME_STATE = "[ERROR] 잘못된 상태가 넘어왔습니다."

class OutputView {

    fun printErrorMessage(message: String) {
        println(message)
    }

    fun printBlank() {
        println()
    }

    fun printGameStart() {
        println(GAME_START)
        println()
        println(ENTER_BRIDGE_SIZE)
    }

    fun printUpDownRequest() {
        println(SELECT_UP_DOWN)
    }

    fun printMap(upperBlocks: List<String>, downerBlocks: List<String>) {
        printBlocks(upperBlocks)
        printBlocks(downerBlocks)
        println()
    }

    private fun printBlocks(blocks: List<String>) {
        println(blocks.joinToString(prefix = BRIDGE_START, postfix = BRIDGE_END, separator = DIVISION_LINE))
    }

    fun printRetryRequest() {
        println()
        println(ENTER_RETRY_END)
    }

    fun printResult(gameResult: GameResult) {
        printFinalResult()
        printMap(gameResult.upperBlocks, gameResult.downerBlocks)
        printSuccessOrFailure(gameResult.gameState)
        printTryCount(gameResult.tryCount)
    }

    private fun printFinalResult() {
        println(FINAL_RESULT)
    }

    private fun printSuccessOrFailure(result: GameState) {
        when (result) {
            GameState.SUCCESS -> println(GameState.SUCCESS.result)
            GameState.FAILURE -> println(GameState.FAILURE.result)
            GameState.IN_GAME -> throw IllegalStateException(WRONG_GAME_STATE)
        }
    }

    private fun printTryCount(tryCount: Int) {
        println(TOTAL_TRY_COUNT + tryCount.toString())
    }
}
