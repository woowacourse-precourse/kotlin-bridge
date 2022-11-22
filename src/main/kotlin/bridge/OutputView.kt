package bridge

import bridge.constant.*


class OutputView {


    fun printMap(bridge:Bridge){
        val roadUntilNow=bridge.getRoadUntilNow().getRoadMap()
        val upperSide=roadUntilNow[0].joinToString(" | ","[ "," ]")
        val lowerSide=roadUntilNow[1].joinToString(" | ","[ "," ]")

        println(upperSide+"\n"+lowerSide+"\n")
    }


    fun printResult(bridge:Bridge,bridgeGame: BridgeGame) {
        println(GAME_RESULT)
        printMap(bridge)
        val successOrFail=if(bridge.getFailFlag()) GAME_FAIL else GAME_SUCCESS
        println(SUCCESS_RESULT_MSG+successOrFail)
        println(ATTEMPTS_NUM_RESULT_MSG+bridgeGame.getPlayerTryCount())
    }
}
