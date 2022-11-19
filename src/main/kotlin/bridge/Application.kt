package bridge

import bridge.view.InputView

fun main() {
    // TODO: 프로그램 구현

    printSize()
}

fun printSize() {
    val size = InputView().readBridgeSize()
    println(size)
}