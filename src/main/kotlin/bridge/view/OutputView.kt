package bridge.view

import bridge.domain.BridgeGame

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
private enum class OutputMessage(val message: String) {
    START("다리 건너기 게임을 시작합니다."),
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    READ_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    START_BRIDGE("[ "),
    MIDDLE_BRIDGE(" | "),
    END_BRIDGE(" ]"),
    READ_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT("최종 게임 결과"),
    WHETHER_GAME_SUCCESS("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    TRY_COUNT("총 시도한 횟수: ")
}

class OutputView {

    fun printStartMent() {
        println(OutputMessage.START.message)
        println()
    }

    fun printReadBridgeSizeMent() {
        println(OutputMessage.READ_BRIDGE_SIZE.message)
    }

    fun printErrorMessage(message: String) {
        println(message)
    }

    fun printReadMovingMent() {
        println(OutputMessage.READ_MOVING.message)
    }

    fun printReadCommandMent() {
        println(OutputMessage.READ_COMMAND.message)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(map: Pair<List<String>, List<String>>) {
        printOneSideMap(map.first)
        printOneSideMap(map.second)
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGame: BridgeGame, isSuccess: Boolean) {
        println(OutputMessage.FINAL_RESULT.message)
        printMap(bridgeGame.getMapResult())
        if (isSuccess) printGameSuccessMent()
        if (!isSuccess) printGameFailMent()
        printTryCount(bridgeGame.getTryCount())
    }

    private fun printOneSideMap(map: List<String>) {
        val size = map.size
        print(OutputMessage.START_BRIDGE.message)
        for (i in 0 until size) {
            print(map[i])
            if (i != size - 1) {
                print(OutputMessage.MIDDLE_BRIDGE.message)
            }
        }
        println(OutputMessage.END_BRIDGE.message)
    }

    private fun printGameSuccessMent() {
        print(OutputMessage.WHETHER_GAME_SUCCESS.message + OutputMessage.SUCCESS.message)
        println()
    }

    private fun printGameFailMent() {
        print(OutputMessage.WHETHER_GAME_SUCCESS.message + OutputMessage.FAIL.message)
        println()
    }

    private fun printTryCount(count: Int) {
        print(OutputMessage.TRY_COUNT.message + count.toString())
        println()
    }
}
