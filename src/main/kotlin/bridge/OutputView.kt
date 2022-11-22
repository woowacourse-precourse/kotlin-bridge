package bridge

import bridge.constant.*


class OutputView {


    fun printMap(bridgeGame: BridgeGame) {
        val roadUntilNow = bridgeGame.getRoadUntilNow().getRoadMap()
        val upperSide = roadUntilNow[0].joinToString(" | ", "[ ", " ]")
        val lowerSide = roadUntilNow[1].joinToString(" | ", "[ ", " ]")

        println(upperSide + "\n" + lowerSide + "\n")
    }


    fun printResult(bridge: Bridge, bridgeGame: BridgeGame) {
        println(GAME_RESULT)
        printMap(bridgeGame)
        val successOrFail = if (!bridge.checkGameEnd(bridgeGame.getPlayerLocation())) GAME_FAIL else GAME_SUCCESS
        println(SUCCESS_RESULT_MSG + successOrFail)
        println(ATTEMPTS_NUM_RESULT_MSG + bridgeGame.getPlayerTryCount())
    }
}
