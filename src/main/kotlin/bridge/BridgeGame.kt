package bridge

import bridge.View.InputView
import bridge.computer.BridgeMaker
import bridge.computer.BridgeRandomNumberGenerator
import bridge.utils.BridgePrint


public var firstLine =  mutableListOf<String>()
public var secondLine =  mutableListOf<String>()

class BridgeGame {

    fun start(){
        firstLine =  mutableListOf<String>(BridgePrint._start)
        secondLine =  mutableListOf<String>(BridgePrint._start)

        val size = InputView().readBridgeSize()
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size).toMutableList()


    }

    fun move(location : Int) : Int {
        return (location + 1)
    }
    fun calculate(moveDirection: String){
        var isRight = checkRightFalse(moveDirection)

        addBetweenWall()

        if(moveDirection == "U"&& isRight && !isLast()){
            firstLine.add(BridgePrint._right)
            secondLine.add(BridgePrint._nothing)
        }
        if(moveDirection == "D" && isRight && !isLast()){
            secondLine.add(BridgePrint._right)
            firstLine.add(BridgePrint._nothing)
        }
        if(moveDirection == "U"&& !isRight && !isLast()){
            firstLine.add(BridgePrint._false)
            secondLine.add(BridgePrint._nothing)
        }
        if(moveDirection == "D" && !isRight && !isLast()){
            secondLine.add(BridgePrint._false)
            firstLine.add(BridgePrint._nothing)
        }

    }

    fun retry() {}

    fun checkRightFalse(moveDirection: String) : Boolean {
        if(bridge[location] == moveDirection ) {
            return true
        }
        return false
    }

    fun isLast(): Boolean {
        if(firstLine.size == bridge.size){
            return true
        }
        return false
    }

    fun addBetweenWall(){
        if(location != 0 && !isLast()){
            firstLine.add(BridgePrint._wall)
            secondLine.add(BridgePrint._wall)
        }
    }
}
