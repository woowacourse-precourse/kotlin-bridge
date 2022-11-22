package bridge.domain

import bridge.data.*
import bridge.ui.InputView
import bridge.ui.OutputView

class GameController() {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()
    private var bridge = listOf<String>()
    private var size = ZERO
    private var level = ZERO

    fun initGame() {
        outputView.printOpening()
        size = inputView.readBridgeSize()
        bridge = bridgeGame.makeBridge(size)
        runGame()
    }

    private fun runGame() {
        while (level < size) {
            outputView.printRequestDirection()
            when (gameInProgress()) {
                QUIT -> return
                RETRY -> { level = ZERO; continue }
                KEEP -> { level++; printBridge() }
            }
        }
        gameResult(true)
    }

    private fun gameInProgress(): String {
        val upAndDown = inputView.readMoving()
        val game = bridgeGame.move(bridge, upAndDown, level)
        if (!game) {
            printBridge()
            outputView.printAskRetry()
            return if (!decideProgress()) QUIT else RETRY
        }
        return KEEP
    }

    private fun decideProgress(): Boolean {
        return if (!checkInput()) {
            gameResult(false)
            false
        } else true
    }

    private fun printBridge() {
        outputView.printMap(getBridgeContainer())
    }

    private fun gameResult(boolean: Boolean) {
        outputView.printResult(getBridgeContainer(), boolean, bridgeGame.getCoin())
    }

    private fun initBridge() {
        bridgeGame.retry()
    }

    private fun getBridgeContainer(): BridgeContainer {
        return BridgeContainer(
            bridgeGame.getUpperBridge(),
            bridgeGame.getLowerBridge()
        )
    }

    private fun checkInput(): Boolean {
        if (inputView.readGameCommand() == QUIT) return false
        initBridge()
        return true
    }

}