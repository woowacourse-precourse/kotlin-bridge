package bridge

object BridgeGameManager {

    fun gameStart() {
        OutputView.printStart()
        val maker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridge = maker.makeBridge()
        moving(bridge)

    }

    private fun moving(bridge: List<Int>) {
        var count = BridgeParameter.StartValue.value
        while (true){
            count++
            val game = BridgeGame()
            game.move(bridge,count)
        }
    }
}