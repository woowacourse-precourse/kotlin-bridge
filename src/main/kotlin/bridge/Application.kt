package bridge

fun main() {
    printStartGame()
    val inputView = InputView()
    inputView.readBridgeSize()
}


fun printStartGame() {
    println(BrideGameConstValue.GAME_START_MESSAGE)
}