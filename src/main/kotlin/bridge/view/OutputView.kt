package bridge.view

import bridge.domain.Bridge
import bridge.domain.BridgeMaker

class OutputView {
    private lateinit var answerBridge: List<String>
    private lateinit var upBridge: Bridge
    private lateinit var downBridge: Bridge
    private lateinit var bridgeMaker: BridgeMaker

    fun init(answerBridge: List<String>, bridgeMaker: BridgeMaker) {
        this.answerBridge = answerBridge
        this.bridgeMaker = bridgeMaker
        this.upBridge = Bridge(bridgeMaker.makeCompletedBridge(answerBridge, UP_BRIDGE))
        this.downBridge = Bridge(bridgeMaker.makeCompletedBridge(answerBridge, DOWN_BRIDGE))
    }

    fun printGameStart() {
        println(GAME_START)
        println()
    }

    fun printRequestInputBridgeSize() {
        println(REQUEST_INPUT_BRIDGE_SIZE)
    }

    fun printRequestInputDirectionToMove() {
        println(REQUEST_INPUT_DIRECTION_TO_MOVE)
    }

    fun printMap(position: Int, isCorrectDirection: Boolean) {
        val upBridge = upBridge.getNowBridge(position)
        val downBridge = downBridge.getNowBridge(position)
        if (isCorrectDirection) printMapCorrectDirection(upBridge, downBridge)
        else printMapUnCorrectDirection(position, upBridge, downBridge)
        println()
    }

    private fun printMapCorrectDirection(upBridge: Bridge, downBridge: Bridge) {
        println(upBridge.toString())
        println(downBridge.toString())
    }

    private fun printMapUnCorrectDirection(position: Int, upBridge: Bridge, downBridge: Bridge) {
        if (answerBridge[position] == ANSWER_UP) {
            println(upBridge.getWrongAnswerBridge(position, SPACE).toString())
            println(downBridge.getWrongAnswerBridge(position, WRONG_ANSWER).toString())
        }
        if (answerBridge[position] == ANSWER_DOWN) {
            println(upBridge.getWrongAnswerBridge(position, WRONG_ANSWER).toString())
            println(downBridge.getWrongAnswerBridge(position, SPACE).toString())
        }
    }

    fun printRequestRestart() {
        println(REQUEST_RESTART)
    }

    fun printResult(position: Int, isCorrectDirection: Boolean) {
        println(GAME_RESULT)
        printMap(position - OVER_POSITION, isCorrectDirection)
    }

    fun printResultDetail(isWin: Boolean, tryCount: Int) {
        println(IS_GAME_SUCCESS.format(if (isWin) SUCCESS else FAILURE))
        println(TOTAL_TRY_COUNT.format(tryCount))
    }

    companion object {
        private const val GAME_START = "다리 건너기 게임을 시작합니다."
        private const val REQUEST_INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
        private const val REQUEST_INPUT_DIRECTION_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        private const val REQUEST_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        private const val GAME_RESULT = "최종 게임 결과"
        private const val IS_GAME_SUCCESS = "게임 성공 여부: %s"
        private const val TOTAL_TRY_COUNT = "총 시도한 횟수: %d"
        private const val SUCCESS = "성공"
        private const val FAILURE = "실패"
        private const val ANSWER_DOWN = "D"
        private const val ANSWER_UP = "U"
        private const val SPACE = " "
        private const val WRONG_ANSWER = "X"
        private const val OVER_POSITION = 1
        private const val UP_BRIDGE = true
        private const val DOWN_BRIDGE = false
    }
}
