package bridge

import bridge.constant.*

private val inputView = InputView()
private val outputView = OutputView()
private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
private val bridgeGame = BridgeGame()
private var bridge_: Bridge? = null
private val bridge
    get() = checkNotNull(bridge_)

fun makeBridge() {
    val bridgeSize = inputView.readBridgeSize()
    bridge_ = Bridge(bridgeMaker.makeBridge(bridgeSize))

}

fun movePlayer(): Boolean {
    val mv = inputView.readMoving()
    val moveResult=bridgeGame.move(mv, bridge)//correct wrong move 중 하나
    outputView.printMap(bridgeGame)

    return moveResult
}

fun requestRetryOrQuit(): Boolean {
    val playerInput = inputView.readGameCommand()
    return if (playerInput == RETRY_GAME) {
        bridgeGame.retry()
        true
    } else {
        false
    }
}

fun playGame(): Boolean {
    val mvResult = movePlayer()
    return if(mvResult){
        !bridge.checkGameEnd(bridgeGame.getPlayerLocation())
        //true일 때는 맞췄을 경우
    }else{
        //틀렸을 경우
        requestRetryOrQuit()
    }

}

fun main() {
    println(GAME_START_MSG)
    makeBridge()
    while (playGame());
    outputView.printResult(bridge, bridgeGame)
}
