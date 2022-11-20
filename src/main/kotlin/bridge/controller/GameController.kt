package bridge.controller

import bridge.domain.BridgeGame
import bridge.domain.BridgeMaker

import bridge.util.RESTART
import bridge.util.START_GAME

import bridge.view.InputView
import bridge.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val bridgeMaker: BridgeMaker
) {
    private lateinit var bridgeGame: BridgeGame
    private var position = 0

    fun start() {
        println(START_GAME)
        val size = inputView.readBridgeSize()
        bridgeGame = BridgeGame(bridgeMaker.makeBridge(size))
        val result = gameProgress(size)
        outputView.printResult(bridgeGame, result)
    }

    // 다리 건너기 게임 진행
    private fun gameProgress(size: Int): Boolean {
        while (position < size) {
            val key = inputView.readMoving()
            val isCorrect = bridgeGame.move(key, position)
            outputView.printMap(bridgeGame)
            position++
            if (isCorrect) continue
            if (isQuit()) return false
        }
        return true
    }

    // 게임 종료
    private fun isQuit(): Boolean {
        val command = inputView.readGameCommand()
        if (command == RESTART) {
            position = 0
            bridgeGame.retry()
            return false
        }
        return true
    }
}