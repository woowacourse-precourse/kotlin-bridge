package bridge.controller

import bridge.domain.*
import bridge.view.InputView
import bridge.view.OutputView

class Controller {
    private val outPutView = OutputView()
    private val inputView = InputView()
    private val bridgeGame = BridgeGame()


    fun run() {
        val user = User()
        outPutView.printGameStart()
        bridgeGameStart(getBridge(), user)
    }

    private fun getBridge(): Bridge {
        val bridgeSize = inputView.readBridgeSize()
        return Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize))
    }

    private fun bridgeGameStart(bridge: Bridge, user: User) {
        do {
            val gameResult = getGameResult(bridge, user)
            when (gameResult) {
                BridgeGame.GameResult.SUCCESS -> successGame(user)
                BridgeGame.GameResult.FAILURE -> failGame(bridge, user)
                BridgeGame.GameResult.CONTINUE -> continueGame(user)
            }
        } while (gameResult == BridgeGame.GameResult.CONTINUE)
    }

    private fun getGameResult(bridge: Bridge, user: User): BridgeGame.GameResult {
        bridgeGame.move(inputView.readMoving(), user)
        return bridgeGame.getGameResult(bridge, user)
    }

    private fun successGame(user: User) {
        outPutView.printMap(bridgeGame.getMap(user.movingResults))
        outPutView.printResult(
            user.tryCount,
            bridgeGame.getGameResultMessage(BridgeGame.GameResult.SUCCESS),
            bridgeGame.getMap(user.movingResults)
        )
    }

    private fun failGame(bridge: Bridge, user: User) {
        outPutView.printMap(bridgeGame.getMap(user.movingResults))
        when (inputView.readGameCommand()) {
            RETRY -> retryGame(bridge, user)
            QUIT -> quitGame(user)
        }
    }

    private fun retryGame(bridge: Bridge, user: User) {
        bridgeGame.retry(user)
        bridgeGameStart(bridge, user)
    }

    private fun quitGame(user: User) {
        outPutView.printResult(
            user.tryCount,
            bridgeGame.getGameResultMessage(BridgeGame.GameResult.FAILURE),
            bridgeGame.getMap(user.movingResults)
        )
    }

    private fun continueGame(user: User) {
        outPutView.printMap(bridgeGame.getMap(user.movingResults))
    }

    companion object {
        const val RETRY = "R"
        const val QUIT = "Q"
    }
}