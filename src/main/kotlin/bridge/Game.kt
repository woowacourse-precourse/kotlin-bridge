package bridge

class Game {
    fun gameStart() {
        val inputView = InputView()
        val size = inputView.readBridgeSize()
    }
}