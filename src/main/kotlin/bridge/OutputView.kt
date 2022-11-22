package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */

enum class Output(val message: String) {
    GAME_START("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    CHOOSE_SPACE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    SUCCESS_OR_NOT("게임 성공 여부: "),
    GAME_CLEAR("성공"),
    GAME_FAIL("실패"),
    TOTAL_ATTEMPTS("총 시도한 횟수: "),
}

class OutputView {
    fun printGameStart() {
        println(Output.GAME_START.message)
        println()
    }

    fun printInputBridgeLength() {
        println(Output.BRIDGE_LENGTH.message)
    }

    fun printChooseSpaceToMove() {
        println(Output.CHOOSE_SPACE.message)
    }

    fun printRetry() {
        println(Output.RETRY_GAME.message)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeGame: BridgeGame, now: Int) {
        val upBridge = bridgeGame.getUpBridge()
        val downBridge = bridgeGame.getDownBridge()
        println(upBridge.slice(0..now).joinToString(" | ", "[ ", " ]"))
        println(downBridge.slice(0..now).joinToString(" | ", "[ ", " ]"))
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGame: BridgeGame, now: Int) {
        println(Output.GAME_RESULT.message)
        printMap(bridgeGame, now - 1)
        when (bridgeGame.getProgressStatus()) {
            true -> println("${Output.SUCCESS_OR_NOT.message}${Output.GAME_CLEAR.message}")
            false -> println("${Output.SUCCESS_OR_NOT.message}${Output.GAME_FAIL.message}")
        }
        println("${Output.TOTAL_ATTEMPTS.message}${bridgeGame.getCountRetry()}")
    }
}
