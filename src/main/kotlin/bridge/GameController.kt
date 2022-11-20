package bridge

import bridge.util.START_GAME

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val bridgeMaker: BridgeMaker
) {
    private lateinit var bridgeGame: BridgeGame

    fun start() {
        println(START_GAME)
        val size = inputView.readBridgeSize()
        bridgeGame = BridgeGame(bridgeMaker.makeBridge(size))
    }
}