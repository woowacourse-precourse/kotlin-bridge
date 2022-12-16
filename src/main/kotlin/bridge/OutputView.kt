package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(realBridges: List<String>, gameBridges: List<String>, curStep: Int) {
        println(upperMap(realBridges, gameBridges, curStep))
        println(downMap(realBridges, gameBridges, curStep) + "\n")
    }

    private fun upperMap(realBridges: List<String>, gameBridges: List<String>, curStep: Int): String {
        val upperBridge = StringBuilder("[ ")
        for (i in 0 until curStep) {
            when (judgementUpperStepMatch(realBridges[i], gameBridges[i])) {
                Match.MATCH -> upperBridge.append("O ")
                Match.FAILED -> upperBridge.append("X ")
                else -> upperBridge.append("  ")
            }
            if (i != curStep - 1) upperBridge.append("| ")
        }
        return upperBridge.append("]").toString()
    }

    // 위쪽 Upper에 대한 결과만 출력. 기준은 사용자다리 기준임. x를 표시해도 거기 사용자가 선택한 곳에 표시한다.
    private fun judgementUpperStepMatch(realBridgesStep: String, gameBridgesStep: String): Match {
        return if (gameBridgesStep == "U" && gameBridgesStep == realBridgesStep) {
            Match.MATCH
        } else if (gameBridgesStep == "U" && gameBridgesStep != realBridgesStep) {
            Match.FAILED
        } else {
            Match.EMPTY
        }
    }

    private fun downMap(realBridges: List<String>, gameBridges: List<String>, curStep: Int): String {
        val downBridge = StringBuilder("[ ")
        for (i in 0 until curStep) {
            when (judgementDownStepMatch(realBridges[i], gameBridges[i])) {
                Match.MATCH -> downBridge.append("O ")
                Match.FAILED -> downBridge.append("X ")
                else -> downBridge.append("  ")
            }
            if (i != curStep - 1) downBridge.append("| ")
        }
        return downBridge.append("]").toString()
    }

    private fun judgementDownStepMatch(realBridgesStep: String, gameBridgesStep: String): Match {
        return if (gameBridgesStep == "D" && gameBridgesStep == realBridgesStep) {
            Match.MATCH
        } else if (gameBridgesStep == "D" && gameBridgesStep != realBridgesStep) {
            Match.FAILED
        } else {
            Match.EMPTY
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(isSuccess: Boolean, tryCount: Int) {
        var result = GAME_RESULT_FAILED
        if (isSuccess) result = GAME_RESULT_SUCCESS
        println(result)
        gameTryCount(tryCount)
    }

    fun gameStartMessage() = println(BRIDGE_GAME_START)
    fun bridgeLengthInputPleaseMessage() = println(BRIDGE_LENGTH_INPUT_PLEASE)
    fun moveInputPleaseMessage() = println(MOVE_INPUT_PLEASE)
    fun retryInputPleaseMessage() = println(RETRY_INPUT_PLEASE)
    fun finalGameResult() = println(FINAL_GAME_RESULT)
    private fun gameTryCount(tryCount: Int) = println("$TRY_COUNT$tryCount")

    companion object {
        private const val BRIDGE_GAME_START = "다리 건너기 게임을 시작합니다."
        private const val BRIDGE_LENGTH_INPUT_PLEASE = "\n다리의 길이를 입력해주세요."
        private const val MOVE_INPUT_PLEASE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)"
        private const val RETRY_INPUT_PLEASE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        private const val FINAL_GAME_RESULT = "최종 게임 결과"
        private const val GAME_RESULT_SUCCESS = "게임 성공 여부: 성공"
        private const val GAME_RESULT_FAILED = "게임 성공 여부: 실패"
        private const val TRY_COUNT = "총 시도한 횟수: "
    }

    enum class Match {
        MATCH, FAILED, EMPTY
    }
}
