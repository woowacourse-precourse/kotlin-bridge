package bridge

import bridge.View.InputView
import bridge.View.OutputView
import bridge.computer.BridgeMaker
import bridge.computer.BridgeRandomNumberGenerator
import bridge.utils.BridgePrint


public var firstLine = mutableListOf<String>()
public var secondLine = mutableListOf<String>()
public var size = 0

class BridgeGame {

    fun initState(){
        size = InputView().readBridgeSize()
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size).toMutableList()
    }

    fun start() {
        firstLine = mutableListOf<String>()
        secondLine = mutableListOf<String>()
        location = -1

    }

    fun move() {
        location += 1
    }

    fun calculate() {

        var moveDirection = InputView().readMoving()
        var isRight = checkRightFalse(moveDirection)


        if (moveDirection == "U" && isRight) {
            firstLine.add(BridgePrint._right)
            secondLine.add(BridgePrint._nothing)
        }
        if (moveDirection == "D" && isRight) {
            secondLine.add(BridgePrint._right)
            firstLine.add(BridgePrint._nothing)
        }

        if (moveDirection == "U" && !isRight) {
            firstLine.add(BridgePrint._false)
            secondLine.add(BridgePrint._nothing)
            OutputView().printMap()
            BridgeGame().retry()
        }
        if (moveDirection == "D" && !isRight) {
            secondLine.add(BridgePrint._false)
            firstLine.add(BridgePrint._nothing)
            OutputView().printMap()
            BridgeGame().retry()
        }
        if (isLast()) {
            GameClear()
        }

    }

    fun retry() {
        var answer = InputView().readGameCommand()
        if (answer == "R") {
            gameCount += 1
            BridgeGame().start()
        }
        if (answer == "Q"){
            BridgeGame().end()
        }
    }

    fun end() {
        OutputView().printResult()
    }

    fun checkRightFalse(moveDirection: String): Boolean {
        if (bridge[location] == moveDirection) {
            return true
        }
        return false
    }

    fun isLast(): Boolean {
        if (firstLine.size == bridge.size ) {
            return true
        }
        return false
    }

    fun GameClear() {
        isGameClear = true
    }
}
