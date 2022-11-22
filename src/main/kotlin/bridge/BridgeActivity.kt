package bridge

import bridge.ui.InputView
import bridge.ui.OutputView

class BridgeActivity {

    fun bridgeGame() {
        println("다리 건너기 게임을 시작합니다.")
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(InputView().readBridgeSize())
        val bridgeGame = OutputView().printMap(bridge)
        OutputView().printResult(bridgeGame.first.upRowsResult,bridgeGame.first.downRowsResult,bridgeGame.second)
    }

}