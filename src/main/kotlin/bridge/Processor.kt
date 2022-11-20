package bridge

class Processor(
    val bridgeMaker: BridgeMaker,
    val bridgeGame: BridgeGame,
    val inputView: InputView,
    val outputView: OutputView,
) {
    var playerPosition = 0
    var numberOfTry = 1
    var isSucceeded=false
    lateinit var bridgeMap: Array<String>
    lateinit var bridge: List<String>

    fun initBridge() {
        do{
            val isInitialized = runCatching {
                val bridgeSize = inputView.readBridgeSize()

                bridge = bridgeMaker.makeBridge(bridgeSize)
                initBridgeMap()
            }
        }while(isInitialized.isFailure)
    }

    fun initBridgeMap(){
        bridgeMap = Array(2) { "[ N ]".repeat(bridge.size).replace("][", "|") }
    }

    fun move(): Pair<GameStatus, String> {
        val playerDirection = inputView.readMoving()
        val gameStatus = bridgeGame.move(bridge, playerDirection)

        if(gameStatus==GameStatus.SUCCEEDED){
            isSucceeded=true
        }
        return Pair(gameStatus, playerDirection)
    }

    fun recordToBridgeMap(gameStatus: GameStatus, playerDirection: String) {
        val recordSign = if (gameStatus!=GameStatus.FAILED) {
            "O"
        } else {
            "X"
        }
        bridgeMap[playerDirection.directionToInt()] =
            bridgeMap[playerDirection.directionToInt()].replaceFirst(" N ", " $recordSign ")
        bridgeMap[playerDirection.oppositeDirectionToInt()] =
            bridgeMap[playerDirection.oppositeDirectionToInt()].replaceFirst(" N ", "   ")
    }


    fun askRetry(): Boolean {
        val retryInput = inputView.readGameCommand() == "R"
        initBridgeMap()
        bridgeGame.retry()
        numberOfTry++
        return retryInput
    }

    fun printMap() {
        outputView.printMap(bridgeMap[0])
        outputView.printMap(bridgeMap[1])
    }

    private fun String.directionToInt() = if (this == "D") {
        1
    } else {
        0
    }

    private fun String.oppositeDirectionToInt() = if (this == "D") {
        0
    } else {
        1
    }

    fun finish() {
        outputView.printResult(bridgeMap, numberOfTry, isSucceeded)
    }
}