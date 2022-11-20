package bridge.controller

import bridge.domain.map.RouteMap
import bridge.domain.result.RoundResult
import bridge.presentation.InputView
import bridge.presentation.OutputView
import bridge.service.BridgeGame
import bridge.service.Result
import bridge.util.constant.BASE_ROUND
import bridge.util.constant.FINISH_GAME
import bridge.util.constant.RETRY
import bridge.util.constant.RETRY_GAME

class BridgeGameController {
    private val inputView: InputView by lazy { InputView() }
    private val outputView: OutputView by lazy { OutputView() }

    private val bridgeGame: BridgeGame by lazy { BridgeGame() }


    fun startGame() {
        outputView.printStartMessage()
        bridgeGame.generateBridge(requestBridgeSize())
        outputView.enter()

        do {
            val isRetry = startBridgeGame()
        } while (isRetry)
    }

    private fun startBridgeGame(): Boolean {
        bridgeGame.startBridgeGame()
        for (round in BASE_ROUND until bridgeGame.bridgeSize()) {
            val roundResult = startRound(round)
            val finalPosition = bridgeGame.finalPosition()
            val retry = processResult(roundResult, finalPosition)

            if (retry) { return RETRY_GAME }
            if (roundResult.result == Result.FAIL) { return FINISH_GAME }
        }
        return FINISH_GAME
    }

    private fun startRound(round: Int): RoundResult {
        val direction = requestDirection()
        bridgeGame.move(direction)

        val roundResult = bridgeGame.startRound(round)
        drawRoute(bridgeGame.currentPlayerRoute())

        return roundResult
    }

    private fun drawRoute(route: RouteMap) {
        outputView.printMap(route)
    }

    private fun processResult(roundResult: RoundResult, finalRound: Int): Boolean = when (roundResult.result) {
        Result.SUCCESS -> successResult(roundResult, finalRound)
        Result.FAIL -> failResult(roundResult)
    }

    private fun successResult(roundResult: RoundResult, finalRound: Int): Boolean = with(roundResult) {
        if (round == finalRound) {
            printResult(result, playerRoute, tryCount)
        }
        return FINISH_GAME
    }


    private fun failResult(roundResult: RoundResult): Boolean = with(roundResult) {
        outputView.printRetryQuestion()
        if (requestRetry()) {
            bridgeGame.retry()
            return RETRY_GAME
        }

        printResult(result, playerRoute, tryCount)
        return FINISH_GAME
    }

    private fun printResult(gameResult: Result, playerRoute: RouteMap, tryCount: Int) {
        outputView.printResult(gameResult, playerRoute, tryCount)
    }

    private fun requestRetry(): Boolean = try {
        (inputView.readGameCommand() == RETRY)
    } catch (error: IllegalArgumentException) {
        outputView.printError(error)
        requestRetry()
    }

    private fun requestBridgeSize(): Int {
        outputView.printBridgeLengthQuestion()

        return try {
            inputView.readBridgeSize()
        } catch (error: IllegalArgumentException) {
            outputView.printError(error)
            requestBridgeSize()
        }
    }

    private fun requestDirection(): String {
        outputView.printDirectionQuestion()

        return try {
            inputView.readDirection()
        } catch (error: IllegalArgumentException) {
            outputView.printError(error)
            requestDirection()
        }
    }
}