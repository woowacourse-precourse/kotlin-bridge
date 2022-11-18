package bridge

object BridgeGameManager {

    fun gameStart() {
        val maker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridge = maker.makeBridge()
        moving(bridge)

    }

    private fun moving(bridge: List<Int>) {
        val game = BridgeGame()
    }
}