package bridge

import bridge.domain.data.BridgeOutputText
import bridge.ui.InputView
import bridge.ui.OutputView

class BridgeActivity {

    fun bridgeGame() {
        println(BridgeOutputText.BRIDGE_GAME_START.text)
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(InputView().readBridgeSize())
        val bridgeGame = OutputView().printMap(bridge)
        OutputView().printResult(bridgeGame.first.upRowsResult,bridgeGame.first.downRowsResult,bridgeGame.second)
    }

}