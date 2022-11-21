package bridge

import domain.BridgeGame
import view.InputView
import view.OutputView
import java.lang.IllegalArgumentException

private var bridgeSize:Int ?= null
private val outputView = OutputView()
private val inputView = InputView()
private val MESSAGE_ERROR = "[ERROR]"

fun main() {
    // 게임 시작 메시지 출력
    println(outputView.printStart())
    // 다리 길이 입력
    bridgeSize()
    println("$bridgeSize\n")
    // 이동 칸 입력
    bridgeGame()
}

private fun bridgeSize(){
    println(outputView.printBridgeSize())
    try{
        bridgeSize = inputView.readBridgeSize()
    }catch (e: IllegalArgumentException){
        println("$MESSAGE_ERROR $e")
    }
}

private fun bridgeGame(){
    val bridgeGame = BridgeGame()
    try {
        bridgeSize?.let { bridgeGame.move(it) }
    }catch (e: IllegalArgumentException){
        println("$MESSAGE_ERROR $e")
    }
}