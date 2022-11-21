package bridge

private val output = OutputView()
private val input = InputView()
private val bridgeGame = BridgeGame()
fun main() {
    start()
    var retry: Boolean // 재시작 여부 + 끝까지 이동에 성공할 경우엔 완주했는지에 대한 여부
    var isArrived: Boolean

    do {
        val isMovable = move()
        retry = retry(isMovable)
        isArrived = arrived()
    } while(isArrived.not() && retry)

    gameOver(retry)
}


private fun start() {
    output.printGameStart()
    output.printInputBridgeSize()
    val bridgeSize = input.readBridgeSize()
    bridgeGame.start(bridgeSize)
}

private fun move(): Boolean {
    output.printInputMoving()
    val moving = input.readMoving()

    return bridgeGame.move(moving)
}

private fun retry(isMovable: Boolean): Boolean {
    if(isMovable) return true

    output.printRetry()
    val command = input.readGameCommand()
    return bridgeGame.retry(command)
}

private fun arrived(): Boolean {
    return bridgeGame.arrivedEndOfBridge()
}

private fun gameOver(isSuccess: Boolean) {
    bridgeGame.gameOver(isSuccess)
}