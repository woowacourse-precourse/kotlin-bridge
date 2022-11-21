package bridge

class BridgeGamePlay: BridgeNumberGenerator {
    override fun generate(): Int {
        TODO("Not yet implemented")
    }


    fun play(){
        val inputView = InputView()

        val bridgeSize = inputView.readBridgeSize()

        println(bridgeSize)

    }



}