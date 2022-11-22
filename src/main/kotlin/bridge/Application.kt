package bridge

private val output = OutputView()
private val input = InputView()
fun main() {
    val bridgeGame = BridgeGame()
    start(bridgeGame)
    var retry: Boolean // 재시작 여부 + 끝까지 이동에 성공할 경우엔 완주했는지에 대한 여부
    var isArrived: Boolean
    do {
        val isMovable = move(bridgeGame)
        retry = retry(bridgeGame, isMovable)
        isArrived = arrived(bridgeGame)
    } while(isArrived.not() && retry) // 도착하지 않았고, 재시작할 거라면 반복. 하나라도 그렇지 않으면 반복 나가기

    gameOver(bridgeGame, retry)
}


private fun start(bridgeGame: BridgeGame) {
    output.printGameStart()
    output.printInputBridgeSize()
    val bridgeSize = input.readBridgeSize()
    bridgeGame.start(bridgeSize)
}

private fun move(bridgeGame: BridgeGame): Boolean {
    output.printInputMoving()
    val moving = input.readMoving()

    return bridgeGame.move(moving)
}

private fun retry(bridgeGame: BridgeGame, isMovable: Boolean): Boolean {
    if(isMovable) return true

    output.printRetry()
    val command = input.readGameCommand()
    return bridgeGame.retry(command)
}

private fun arrived(bridgeGame: BridgeGame): Boolean {
    return bridgeGame.arrivedEndOfBridge()
}

private fun gameOver(bridgeGame:BridgeGame, isSuccess: Boolean) {
    bridgeGame.gameOver(isSuccess)
}