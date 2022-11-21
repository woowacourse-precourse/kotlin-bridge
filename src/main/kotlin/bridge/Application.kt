package bridge

fun main() {
    printStartGame()
    val inputView = InputView()
    inputView.readBridgeSize()

    inputView.readMoving()
    inputView.readGameCommand()
}


fun printStartGame() {
    println(BrideGameConstValue.GAME_START_MESSAGE)
}