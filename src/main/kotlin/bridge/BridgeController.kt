package bridge

class BridgeController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val bridgeGame = BridgeGame()

    private val bridgeSize: Int
    private val bridge: List<String>

    private val playerBridge = mutableListOf<Pair<String, String>>()

    private var nowPlace = 0
    private var tryCount = 1
    private var gameResult = false

    init {
        outputView.printStartGame()
        outputView.printInputBridgeSize()
        bridgeSize = inputView.readBridgeSize()
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    }

    fun startBridgeGame() {
        outputView.printInputMoveBridge()
        val moveData = inputView.readMoving()

        playerBridge.add(Pair(moveData, bridgeGame.move(moveData, bridge[nowPlace])))
        nowPlace += 1
        outputView.printMap(playerBridge)
    }

    fun isFinished(): Boolean {
        if(playerBridge.size == bridgeSize)
            return true
        if(playerBridge[playerBridge.size - 1].second == "X")
            return true
        return false
    }

    fun isSuccess(): Boolean {
        if(playerBridge.size == bridgeSize && playerBridge[playerBridge.size - 1].second == "O") {
            gameResult = true
            gameOver()
            return true
        }
        return false
    }

    private fun setRetry() {
        playerBridge.clear()
        nowPlace = 0
        tryCount += 1
        gameResult = false
    }

    fun retryOrExit(): Boolean {
        outputView.printInputRetryOrExit()
        if(bridgeGame.retry(inputView.readGameCommand())) {
            setRetry()
            return true
        }
        gameOver()
        return false
    }

    private fun gameOver() {
        outputView.printResult(gameResult, tryCount, playerBridge)
    }
}