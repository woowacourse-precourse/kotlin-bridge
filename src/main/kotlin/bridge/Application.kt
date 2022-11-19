package bridge

import bridge.view.InputView
import java.lang.IllegalArgumentException

fun main() {
    // TODO: 프로그램 구현
    InputView().startPhrases()
    val size = printSize()
    println(size)
}

//다리 크기 입력 (예외 처리)
fun printSize() : String{
    try{

        val size = InputView().readBridgeSize()
        CheckException().checkInput(size)
        return size

    } catch (e : IllegalArgumentException){
        println(e)
        println("\n")
        val size = printSize()
        return size
    }
}
