package bridge

object BridgeGameManager {

    fun GameStart(){
        val maker = BridgeMaker(BridgeRandomNumberGenerator())
        maker.makeBridge()


    }
}