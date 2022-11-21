package bridge

import domain.BridgeGame
import view.InputView
import view.OutputView
import java.lang.IllegalArgumentException

private var bridgeSize:Int ?= null
fun main() {

    val outputView = OutputView()
    val inputView = InputView()

    // 게임 시작 메시지 출력
    println(outputView.printStart())

    // 다리 길이 입력
    println(outputView.printBridgeSize())
    try{
        bridgeSize = inputView.readBridgeSize()
    }catch (e: IllegalArgumentException){
        println("[ERROR] $e")
    }

    println("$bridgeSize\n")

    // 이동 칸 입력
    val bridgeGame = BridgeGame()
    try {
        bridgeSize?.let { bridgeGame.move(it) }
    }catch (e: IllegalArgumentException){
        println("[ERROR] $e")
    }


}
