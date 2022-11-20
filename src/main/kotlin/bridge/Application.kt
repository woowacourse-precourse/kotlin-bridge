package bridge

import bridge.view.InputView

import kotlin.IllegalArgumentException


fun main() {

    // TODO: 프로그램 구현
    InputView().startPhrases()
    val size = printSize().toInt()
    //println(size)

    var bridge = printBridge(size)
    println(bridge)
    println()

    val move = printDirection()
    println(move)

}

//다리 크기 입력 (예외 처리)
fun printSize(): String {
    try {
        val size = InputView().readBridgeSize()
        CheckException().checkInputSize(size)
        return size
    } catch (e: IllegalArgumentException) {
        println(e)
        println("\n")
        val size = printSize()
        return size
    }
}

fun printBridge(num: Int): List<String> {
    val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    var arr = arrayListOf<String>()
    arr = BridgeMaker(bridgeNumberGenerator).makeBridge(num) as ArrayList<String>

    return arr
}

fun printDirection(): String {
    try {
        val move = InputView().readMoving()
        CheckException().checkInputDirection(move)
        return move
    }catch (e : IllegalArgumentException){
        println(e)
        println("\n")
        val move = printDirection()
        return move
    }

}
