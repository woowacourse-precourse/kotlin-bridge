package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    companion object {
        const val START = "다리 건너기 게임을 시작합니다."
        const val INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
        const val INPUT_STEP_SIDE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        const val INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        const val FINAL_RESULT = "최종 게임 결과"
        const val GAME_CLEAR = "게임 성공 여부: %s"
        const val RETRY_COUNT = "총 시도한 횟수: %d"
    }

    fun printFormattedMsg(msg: String, vararg params: Any) {
        val formattedMsg = String.format(msg, *params)
        println(formattedMsg)
    }

    private fun printSingleBridge(userStep: MutableList<Pair<String, Boolean>>, side: String) {
        print("[ ")
        for (i in userStep.indices) {
            print(if (i == 0) "" else " | ")
            if (side != userStep[i].first)
                print(" ")
            else
                print(if (userStep[i].second) "O" else "X")
        }
        println(" ]")
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun printMap(userStep: MutableList<Pair<String, Boolean>>) {
        printSingleBridge(userStep, "U")
        printSingleBridge(userStep, "D")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(userStep: MutableList<Pair<String, Boolean>>, retryCount: Int) {
        printFormattedMsg(FINAL_RESULT)
        printMap(userStep)
        printFormattedMsg(GAME_CLEAR, if (userStep.map { it.second }.contains(false)) "실패" else "성공")
        printFormattedMsg(RETRY_COUNT, retryCount)
    }
}
