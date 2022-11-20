package bridge

import bridge.domain.BridgeGame
import bridge.domain.BridgeMaker
import bridge.domain.BridgeRandomNumberGenerator
import bridge.ui.InputView
import bridge.ui.OutputView
import bridge.utils.*

fun main() {
    println(GAME_START_MSG)
    val inputView = InputView()

    println(SIZE_INPUT_MSG)
    val bridgeSize = inputView.readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    println(bridge)

    val outputView = OutputView()
    var map: List<String>
    for ((column, actual) in bridge.withIndex()) {
        println(MOVE_INPUT_MSG)
        val predict = inputView.readMoving()
        map = outputView.printMap(column, actual, predict)
        println(map[0])
        println(map[1])

//        val bridgeGame = BridgeGame()
//        val crossable = bridgeGame.move(actual, predict)
//        if (!crossable) {
//            println(GAME_CMD_INPUT_MSG)
//            if(inputView.readGameCommand() == RESTART){
//                bridgeGame.retry()
//                continue
//            }else {
//                outputView.printResult(map, FAIL, bridgeGame.getTryNumber())
//                break
//            }
//        }
    }

    // todo: 끝까지 다리를 건넌 경우에도 printResult
}
