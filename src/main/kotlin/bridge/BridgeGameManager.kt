package bridge

object BridgeGameManager {

    fun GameStart(){
        val maker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridge = maker.makeBridge()
        moving(bridge)

    }

    fun moving(bridge : List<Int>){

    }
}