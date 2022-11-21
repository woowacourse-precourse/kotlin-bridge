package bridge.view

import bridge.common.GameResult
import bridge.common.GameState

private const val BRIDGE_START = "[ "
private const val BRIDGE_END = " ]"
private const val DIVISION_LINE = " | "

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
private const val GAME_START = "다리 건너기 게임을 시작합니다."
private const val ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
private const val SELECT_UP_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
private const val ENTER_RETRY_END = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
private const val FINAL_RESULT = "최종 게임 결과"
private const val SUCCESS_OR_FAILURE = "게임 성공 여부: "
private const val SUCCESS = "성공"
private const val FAILURE = "실패"
private const val TOTAL_TRY_COUNT = "총 시도한 횟수: "

private const val WRONG_GAME_STATE = "[ERROR] 잘못된 상태가 넘어왔습니다."

class OutputView {
    fun printGameStart() {
        println(GAME_START)
    }

    fun printBridgeSizeRequest() {
        println(ENTER_BRIDGE_SIZE)
    }

    fun printUpDownRequest() {
        println(SELECT_UP_DOWN)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(upperBlocks: List<String>, downerBlocks: List<String>) {
        printBlocks(upperBlocks)
        printBlocks(downerBlocks)
    }

    private fun printBlocks(blocks: List<String>) {
        println(blocks.joinToString(prefix = BRIDGE_START, postfix = BRIDGE_END, separator = DIVISION_LINE))
    }

    fun printRetryRequest() {
        println(ENTER_RETRY_END)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
            GameState.SUCCESS -> println(SUCCESS_OR_FAILURE + SUCCESS)
            GameState.FAILURE -> println(SUCCESS_OR_FAILURE + FAILURE)
            GameState.IN_GAME -> throw IllegalArgumentException(WRONG_GAME_STATE)
        }
    }

    private fun printTryCount(tryCount: Int) {
        println(TOTAL_TRY_COUNT + tryCount.toString())
    }
}
