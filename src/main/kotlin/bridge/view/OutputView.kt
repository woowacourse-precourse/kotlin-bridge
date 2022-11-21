package bridge.view

import bridge.domain.BridgeGame
import bridge.domain.Stage

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(gameResult: BridgeGame) {
        printUpperMap(gameResult.getPlayerBridge())
        printLowerMap(gameResult.getPlayerBridge())
    }

    private fun printUpperMap(gameResult: List<Stage>) {
        val upBridge = mutableListOf<String>()
        for (stage in gameResult) {
            upBridge.add(Stage.makeUpBridgeMap(stage))
        }
        print("[ ${upBridge.joinToString(SEPARATOR)} ]\n")
    }

    private fun printLowerMap(gameResult: List<Stage>) {
        val downBridge = mutableListOf<String>()
        for (stage in gameResult) {
            downBridge.add(Stage.makeDownBridgeMap(stage))
        }
        print("[ ${downBridge.joinToString(SEPARATOR)} ]\n")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGameResult: BridgeGame) {
        println(GAME_RESULT_MESSAGE)
        printMap(bridgeGameResult)
        println(GAME_SUCCESS_OR_NOT_MESSAGE + isClearGame(bridgeGameResult.isClear()))
        println(TOTAL_TRY_NUMBER_MESSAGE + bridgeGameResult.getTryNumber())
    }

    private fun isClearGame(isClear: Boolean): String {
        if (isClear) {
            return SUCCESS
        }
        return FAIL
    }

    companion object {
        const val SUCCESS = "성공"
        const val FAIL = "실패"
        const val SEPARATOR = " | "
        const val GAME_RESULT_MESSAGE = "\n최종 게임 결과"
        const val GAME_SUCCESS_OR_NOT_MESSAGE = "\n게임 성공 여부: "
        const val TOTAL_TRY_NUMBER_MESSAGE = "총 시도한 횟수: "
    }
}
