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
        for (i in 0..curStep) {
            when (judgementUpperStepMatch(realBridges[i], gameBridges[i])) {
                Match.MATCH -> upperBridge.append("O ")
                Match.FAILED -> upperBridge.append("X ")
                else -> upperBridge.append("  ")
            }
            if (i != curStep) upperBridge.append("| ")
        }
        return upperBridge.append("]").toString()
    }

    private fun judgementUpperStepMatch(realBridgesStep: String, gameBridgesStep: String): Match {
        return if (realBridgesStep == "U" && gameBridgesStep == realBridgesStep) {
            Match.MATCH
        } else if (realBridgesStep == "U" && gameBridgesStep != realBridgesStep) {
            Match.FAILED
        } else {
            Match.EMPTY
        }
    }

    private fun downMap(realBridges: List<String>, gameBridges: List<String>, curStep: Int): String {
        val downBridge = StringBuilder("[ ")
        for (i in 0..curStep) {
            when (judgementDownStepMatch(realBridges[i], gameBridges[i])) {
                Match.MATCH -> downBridge.append("O ")
                Match.FAILED -> downBridge.append("X ")
                else -> downBridge.append("  ")
            }
            if (i != curStep) downBridge.append("| ")
        }
        return downBridge.append("]").toString()
    }

    private fun judgementDownStepMatch(realBridgesStep: String, gameBridgesStep: String): Match {
        return if (realBridgesStep == "D" && gameBridgesStep == realBridgesStep) {
            Match.MATCH
        } else if (realBridgesStep == "D" && gameBridgesStep != realBridgesStep) {
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
    fun moveLengthInputPleaseMessage() = println(MOVE_INPUT_PLEASE)
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

        lateinit var errorType: Error
        fun errorMessage() {
            println(errorType.error)
        }
    }

    enum class Error(val error: String) {
        BRIDGE_INPUT_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
        MOVE_INPUT_ERROR("[ERROR] 이동에 대한 입력은 U(위) 혹은 D(아래)만 가능합니다."),
        RETRY_INPUT_ERROR("[ERROR] 게임 재시도에 대한 입력은 R(재시도) 혹은 Q(종료)만 가능합니다."),
        NON_ERROR("에러 없음"),
    }

    enum class Match {
        MATCH, FAILED, EMPTY
    }
}
