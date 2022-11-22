package bridge

class Game {
    fun gameStart() {
        // 다리 만들기
        val (inputView, size, bridgeGame) = makeBridge()

        // 게임 진행
        val triple = mainGame(size, inputView, bridgeGame)

        // 최종 결과 확인
        val outputView = triple.first
        var lastBridge = triple.second
        var flag = triple.third
        outputView.printResult(lastBridge, flag, bridgeGame.getCount())
    }

    private fun mainGame(size: Int, inputView: InputView, bridgeGame: BridgeGame): Triple<OutputView, MutableList<String>, Boolean> {
        val outputView = OutputView()
        var lastBridge = mutableListOf<String>()
        var idx = 0
        var flag = true
        while (idx < size) {
            val upOrDown = inputView.readMoving()
            if (bridgeGame.move(upOrDown)) {
                lastBridge = outputView.printMap(bridgeGame.userBridge, true)
                idx++
                continue
            }
            lastBridge = outputView.printMap(bridgeGame.userBridge, false)
            if (inputView.readGameCommand() == "R") {
                bridgeGame.retry()
                idx = 0
                continue
            }
            flag = false
            break
        }
        return Triple(outputView, lastBridge, flag)
    }

    private fun makeBridge(): Triple<InputView, Int, BridgeGame> {
        val inputView = InputView()
        val size = inputView.readBridgeSize()

        val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        val bridge = bridgeMaker.makeBridge(size)
        // println(bridge.toString())

        val bridgeGame = BridgeGame(bridge as MutableList<String>)
        return Triple(inputView, size, bridgeGame)
    }
}