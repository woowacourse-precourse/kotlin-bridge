package bridge

import bridge.domain.BridgeGame
import bridge.domain.BridgeMaker
import bridge.domain.BridgeRandomNumberGenerator
import bridge.enums.GameSuccess
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    var gamePlayCount = 1
    val inputView = InputView()
    val bridge = settingBridgeGame(inputView)
    var isGameSuccess: Boolean
    val outputView = OutputView(bridge)
    while (true) {
        val bridgeGame = BridgeGame(bridge)
        isGameSuccess = processBridgeGame(inputView, outputView, bridgeGame)
        if (!decideGameContinue(isGameSuccess, inputView, bridgeGame)) break
        else gamePlayCount += 1
    }
    printGameResult(isGameSuccess, gamePlayCount, outputView)
}


fun printGameResult(isGameSuccess: Boolean, gamePlayCount: Int, outputView: OutputView) {
    outputView.printResult(isGameSuccess)
    printGameIsSuccess(isGameSuccess)
    printGamePlayCount(gamePlayCount)
}


fun decideGameContinue(isGameSuccess: Boolean, inputView: InputView, bridgeGame: BridgeGame): Boolean {
    return if (isGameSuccess) {
        false
    } else {
        val userGameCommand = inputView.readGameCommand()
        return bridgeGame.retry(userGameCommand)
    }
}


fun processBridgeGame(inputView: InputView, outputView: OutputView, bridgeGame: BridgeGame): Boolean {
    var moveCount = 0
    while (moveCount < bridgeGame.getBridge().size) {
        val userMoveDirection = inputView.readMoving()
        outputView.setMoveDirections(bridgeGame.move(userMoveDirection))
        outputView.printMap()
        if (userMoveDirection != bridgeGame.getBridge()[moveCount]) return false
        moveCount += 1
    }
    return true
}

fun settingBridgeGame(inputView: InputView): List<String> {
    printStartBridgeGame()
    val bridgeSize = inputView.readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    return bridgeMaker.makeBridge(bridgeSize)
}


fun printStartBridgeGame() {
    println(BrideGameConstValue.GAME_START_MESSAGE)
}

fun printGameIsSuccess(isGameSuccess: Boolean) {
    if (isGameSuccess) {
        println(BrideGameConstValue.GAME_IS_SUCCESS + GameSuccess.SUCCESS.getGameSuccess())
    } else {
        println(BrideGameConstValue.GAME_IS_SUCCESS + GameSuccess.FAIL.getGameSuccess())
    }
}

fun printGamePlayCount(gamePlayCount: Int) {
    print(BrideGameConstValue.GAME_PLAY_COUNT + gamePlayCount)
}
