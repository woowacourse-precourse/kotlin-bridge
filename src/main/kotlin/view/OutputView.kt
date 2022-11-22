package view

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun printMap(bridge: List<String>, input: List<String>) {
        printUpDecide(bridge, input)
        println()
        printDownDecide(bridge, input)
        println()
    }

    private fun printDownDecide(bridge: List<String>, input: List<String>) {
        print(BRIDGE_START)
        input.forEachIndexed { idx, value ->
            val decide = checkDownDecide(idx, value, bridge)
            print(" $decide ")
            if (idx != input.size - 1) print(BRIDGE_MID)
        }
        print(BRIDGE_END)
    }

    private fun printUpDecide(bridge: List<String>, input: List<String>) {
        print(BRIDGE_START)
        input.forEachIndexed { idx, value ->
            val decide = checkUpDecide(idx, value, bridge)
            print(" $decide ")
            if (idx != input.size - 1) print(BRIDGE_MID)
        }
        print(BRIDGE_END)
    }

    private fun checkDownDecide(idx: Int, value: String, bridge: List<String>): String {
        when {
            value == BRIDGE_DOWN && value == bridge[idx] -> return USER_ALIVE
            value == BRIDGE_DOWN && value != bridge[idx] -> return USER_DIE
        }
        return SPACE
    }

    private fun checkUpDecide(idx: Int, value: String, bridge: List<String>): String {
        when {
            value == BRIDGE_UP && value == bridge[idx] -> return USER_ALIVE
            value == BRIDGE_UP && value != bridge[idx] -> return USER_DIE
        }
        return SPACE
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() = println(FINAL_RESULT)

    fun printStartGame() = println(START_GAME)

    fun printInputBridgeLength() = println(INPUT_BRIDGE_LENGTH)

    fun printMoveBridge() = println(MOVE_BRIDGE)

    fun printRetryGame() = println(RETRY_GAME)

    fun printGameSuccess(isSuccess: Boolean) {
        var result = FAIL
        if (isSuccess) result = SUCCESS
        println("$SUCCESS_GAME_CHECK $result")
    }

    fun printTryCount(count: Int) = println("$TRY_COUNT $count")

    companion object {
        const val START_GAME = "다리 건너기 게임을 시작합니다."
        const val INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요."
        const val MOVE_BRIDGE = "이동할 칸을 선택해주세요. (위 : U, 아래 : D)"
        const val RETRY_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        const val FINAL_RESULT = "최종 게임 결과"
        const val SUCCESS_GAME_CHECK = "게임 성공 여부:"
        const val TRY_COUNT = "총 시도한 횟수:"
        const val SUCCESS = "성공"
        const val FAIL = "실패"
        const val USER_ALIVE = "O"
        const val USER_DIE = "X"
        const val SPACE = " "
        const val BRIDGE_START = "["
        const val BRIDGE_END = "]"
        const val BRIDGE_MID = "|"
        const val BRIDGE_UP = "U"
        const val BRIDGE_DOWN = "D"
    }
}
