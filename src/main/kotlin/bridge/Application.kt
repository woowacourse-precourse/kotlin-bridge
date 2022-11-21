package bridge

fun main() {
    printStartGame()
    val inputView = InputView()
    val bridgeSize = inputView.readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    println(bridge)


    var moveCount = 0
    val userMoveDirections = mutableListOf<String>()

    while (moveCount < bridgeSize) {
        val userMoveDirection = inputView.readMoving()
        userMoveDirections.add(userMoveDirection)

        val outputView = OutputView(bridge, userMoveDirections, moveCount)
        outputView.printMap()

        moveCount += 1

    }
//    inputView.readMoving()
//    val outputView = OutputView(bridge)

    //inputView.readMoving()
    //inputView.readGameCommand()

}


fun printStartGame() {
    println(BrideGameConstValue.GAME_START_MESSAGE)
}