package bridge

class Game {
    fun gameStart() {
        val inputView = InputView()
        val size = inputView.readBridgeSize()

        val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        val bridge = bridgeMaker.makeBridge(size)
//        println(bridge.toString())

        val bridgeGame = BridgeGame(bridge as MutableList<String>)
        val outputView = OutputView()

        var lastBridge = mutableListOf<String>()
        var idx = 0
        var flag = true
        while (idx < size) {

            val upOrDown = inputView.readMoving()
            if(bridgeGame.move(upOrDown)){
                lastBridge = outputView.printMap(bridgeGame.userBridge, true)
                idx++
                continue
            }
            lastBridge = outputView.printMap(bridgeGame.userBridge, false)
            if(inputView.readGameCommand() == "R"){
                bridgeGame.retry()
                idx = 0
                continue
            }

            flag = false
            break
        }
        outputView.printResult(lastBridge, flag, bridgeGame.getCount())
    }
}