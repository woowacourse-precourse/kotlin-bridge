package bridge

object BridgeGameManager {

    fun gameStart() {
        OutputView.printStart()
        val maker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridge = maker.makeBridge()
        moving(bridge)

    }

    private fun moving(bridge: List<Int>) {
        while (true){
            val game = BridgeGame()
            game.move(bridge)
        }
    }
}