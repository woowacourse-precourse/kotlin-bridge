package bridge


class BrideGameController (){
    private val outputView =  OutputView()
    private val inputView = InputView()
    fun startGame (){
        outputView.printStartGame()
        val bridge = makeBridge()
    }
    private fun makeBridge(): List<String>{
        outputView.printInputLength()
        val bridgeSIze = inputView.readBridgeSize()
        return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSIze)
    }
}