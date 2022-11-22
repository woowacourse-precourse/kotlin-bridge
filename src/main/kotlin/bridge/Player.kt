package bridge

import bridge.domain.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView
import kotlin.properties.Delegates

class Player(private val bridgeGame: BridgeGame) {
    var userSelectedBridgeLength by Delegates.notNull<Int>()
    private val correctRoute: List<String> by lazy { bridgeGame.getBridge(userSelectedBridgeLength) }
    val userSelectedRoute = mutableListOf<String>()
    var tryCount = 1
    var isSuccessEndGame = true

    fun startGame() {
        OutputView().printStartGameGuide()
        setBridgeLength()
        playGame()
        closeGame(isSuccessEndGame)
    }

    fun playGame() {
        while (userSelectedRoute.size < userSelectedBridgeLength && isSuccessEndGame) {
            setNextMoving(userSelectedRoute)
            val isCurrentMovingSuccess = bridgeGame.isCurrentPositionCorrect(correctRoute, userSelectedRoute)
            OutputView().printMap(userSelectedRoute, isCurrentMovingSuccess)
            if (!isCurrentMovingSuccess)
                setRetry()
        }
    }

    fun closeGame(isSuccessGame: Boolean) {
        OutputView().printResult(isSuccessGame, tryCount)
    }

    fun setBridgeLength() {
        userSelectedBridgeLength = InputView().readBridgeSize()
    }

    fun setNextMoving(userSelectedRoute: MutableList<String>) {
        val nextPosition = InputView().readMoving()
        bridgeGame.move(nextPosition, userSelectedRoute)
    }

    fun setRetry() {
        val getRetryGame = bridgeGame.retry()
        if (getRetryGame) {
            userSelectedRoute.removeLast()
            tryCount++
        } else {
            isSuccessEndGame = false
        }
    }
}