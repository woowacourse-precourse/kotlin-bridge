package bridge.view

import bridge.domain.BridgeGame
import bridge.domain.BridgeGamePrinter
import bridge.util.Constant.GAME_FAIL
import bridge.util.Constant.GAME_SUCCESS

class OutputView {

    fun printMap(bridgeGame: BridgeGame) {
        val printer = BridgeGamePrinter
        printer.clear()
        val result = printer.makeMap(bridgeGame)
        println(result.first)
        println(result.second)
    }


    fun printResult(bridgeGame: BridgeGame) {
        val result = BridgeGamePrinter.getResult()
        println(
            String.format(
                "\n최종 게임 결과\n%s\n%s\n\n게임 성공 여부: %s\n총 시도한 횟수: %d",
                result.first,
                result.second,
                if (bridgeGame.isDone()) GAME_SUCCESS else GAME_FAIL,
                bridgeGame.getTryCount()
            )
        )
    }
}
