package bridge

object BridgeGameManager {

    fun gameStart() {
        OutputView.printStart()
        val maker = BridgeMaker(BridgeRandomNumberGenerator())
        OutputView.getBridgeSize()
        val bridge = maker.makeBridge(InputView.readBridgeSize())
        startPlaying(bridge)

    }

    private fun startPlaying(bridge: List<String>) {
        var count = BridgeParameter.StartValue.value
        while (true){
            count++
            val game = BridgeGame()
            game.move(bridge,count)
        }
    }

    fun bridgeMapPrint(bridge: List<String>, record: List<Boolean>){
        OutputView.printMap(BridgeCalculate.upLine(bridge, record))
        OutputView.printMap(BridgeCalculate.downLine(bridge, record))

    }

    fun doNotRetry():Boolean{
        return InputView.readGameCommand()
    }

    fun gameResult(bridge: List<String>, record: List<Boolean>, gameCount: Int) {
        OutputView.printGameEndMessage()
        bridgeMapPrint(bridge, record)
        OutputView.printResult(record, gameCount)
        check(false)
    }

    fun areYouRetry(){
        OutputView.areYouRetry()
    }



}