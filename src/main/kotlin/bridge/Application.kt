package bridge

fun main() {
    printStartBridgeGame()
    var gamePlayCount = 1
    val inputView = InputView()
    val bridge = settingBridgeGame(inputView)
    while (true) {
        val gameIsSuccess = processBridgeGame(inputView, bridge)
        if (gameIsSuccess) {

        } else {
            val userGameCommand = inputView.readGameCommand()
            if (userGameCommand == GameCommand.QUIT.getGameCommand()) {
                printGameIsSuccess()
                printGamePlayCount()
            } else {


            }
        }
    }
}


fun processBridgeGame(inputView: InputView, bridge: List<String>): Boolean {
    var moveCount = 0
    val userMoveDirections = mutableListOf<String>()
    while (moveCount < bridge.size) {
        val userMoveDirection = inputView.readMoving()
        userMoveDirections.add(userMoveDirection)
        val outputView = OutputView(bridge, userMoveDirections, moveCount)
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

fun printGameIsSuccess() {
    println(BrideGameConstValue.GAME_IS_SUCCESS)
}

fun printGamePlayCount() {
    println(BrideGameConstValue.GAME_PLAY_COUNT)
}
