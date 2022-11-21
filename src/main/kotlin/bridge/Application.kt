package bridge

fun main() {
    printStartBridgeGame()
    var gamePlayCount = 1
    val inputView = InputView()
    val bridge = settingBridgeGame(inputView)
    while (true) {
        val gameIsSuccess = processBridgeGame(inputView, bridge)
        if (gameIsSuccess) {

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

