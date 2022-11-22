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
    fun printMap(bridgeGame: BridgeGame) {
        val upperBridge = bridgeGame.upperBridge.toList()
        val downBridge = bridgeGame.downBridge.toList()
        printBridge(upperBridge)
        printBridge(downBridge)
    }

    private fun printBridge(bridge: List<String>) {
        println("$FRONT_BRACKET ${bridge.joinToString(SEPARATOR)} $LAST_BRACKET")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGame: BridgeGame, isSuccess: Boolean, tryCounter: Int) {
        printGameResultMessage()
        this.printMap(bridgeGame)
        when (isSuccess) {
            true -> printSuccessGameMessage()
            false -> printFailureGameMessage()
        }
        printTryCountMessage(tryCounter)
    }
    
    private fun printGameResultMessage() = println(GAME_RESULT_MESSAGE)
    private fun printSuccessGameMessage() = println(SUCCESS_GAME_MESSAGE)
    private fun printFailureGameMessage() = println(FAILURE_GAME_MESSAGE)
    private fun printTryCountMessage(tryCounter: Int) = println("$TRY_COUNT_MESSAGE$tryCounter")

    companion object {
        const val FRONT_BRACKET = "["
        const val LAST_BRACKET = "]"
        const val SEPARATOR = " | "
        const val GAME_RESULT_MESSAGE = "최종 게임 결과"
        const val SUCCESS_GAME_MESSAGE = "게임 성공 여부: 성공"
        const val FAILURE_GAME_MESSAGE = "게임 성공 여부: 실패"
        const val TRY_COUNT_MESSAGE = "총 시도한 횟수: "
    }
}
