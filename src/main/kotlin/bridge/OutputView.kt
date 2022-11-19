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
    fun printMap(bridgeMap: List<String>) {}

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    // 인자 줄여보기
    fun printResult(bridgeMap: List<String>, successOrFail: String, tryingCount: Int) {
        println(GAME_OVER_RESULT)
        printMap(bridgeMap)
        println(GAME_SUCCESS_OR_FAIL.format(successOrFail))
        println(TOTAL_TRYING_COUNT.format(tryingCount))
    }

    fun printGameStart() {
        println(GAME_START)
    }

    fun printInputBridgeSize() {
        println(INPUT_BRIDGE_SIZE)
    }

    fun printInputMoving() {
        println(INPUT_MOVING)
    }

    companion object {
        // output에서만 사용할거니까 message는 없애자
        const val GAME_START = "다리 건너기 게임을 시작합니다."
        const val INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
        const val GAME_OVER_RESULT = "최종 게임 결과"
        const val GAME_SUCCESS_OR_FAIL = "게임 성공 여부: %s"
        const val TOTAL_TRYING_COUNT = "총 시도한 횟수: %d"
        const val INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    }
}
