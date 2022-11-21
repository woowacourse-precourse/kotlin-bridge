package bridge

fun main() {
    var gamePlayCount = 1
    val inputView = InputView()
    val bridge = settingBridgeGame(inputView)
    var gameIsSuccess: Boolean
    while (true) {
        val bridgeGame = BridgeGame()
        gameIsSuccess = processBridgeGame(inputView, bridge, bridgeGame)
        if (!decideGameContinue(gameIsSuccess, inputView, bridgeGame)){
            break
        } else{
            gamePlayCount += 1
        }
    }
    printGameResult(gameIsSuccess, gamePlayCount)
}

fun printGameResult(isGameSuccess: Boolean, gamePlayCount: Int) {
    printGameIsSuccess(isGameSuccess)
    printGamePlayCount(gamePlayCount)
}


fun decideGameContinue(gameIsSuccess: Boolean, inputView: InputView, bridgeGame: BridgeGame): Boolean {
    return if (gameIsSuccess) {
        false
    } else {
        val userGameCommand = inputView.readGameCommand()
        return bridgeGame.retry(userGameCommand)
    }

}


fun processBridgeGame(inputView: InputView, bridge: List<String>, bridgeGame: BridgeGame): Boolean {
    var moveCount = 0
    while (moveCount < bridge.size) {
        val userMoveDirection = inputView.readMoving()
        val outputView = OutputView(bridge, bridgeGame.move(userMoveDirection), moveCount)
        outputView.printMap()
        if (userMoveDirection != bridge[moveCount]) {
            return false
        }
        moveCount += 1
    }
    return true
}

fun settingBridgeGame(inputView: InputView): List<String> {
    printStartBridgeGame()
    val bridgeSize = inputView.readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    println(bridge)
    return bridge
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
    println(BrideGameConstValue.GAME_PLAY_COUNT + gamePlayCount)
}
