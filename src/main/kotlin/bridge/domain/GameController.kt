package bridge.domain

import bridge.ui.InputView
import bridge.ui.OutputView

class GameController() {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()
    private var size = 0
    private var bridge = listOf<String>()

    fun initGame() {
        outputView.printOpening()

        size = inputView.readBridgeSize()
        bridge = bridgeGame.makeBridge(size)
        println(bridge) // 이후 삭제


    }

}