package bridge

fun main() {
    println("다리 건너기 게임을 시작합니다.\n")

    InputView().readBridgeSize()
    InputView().checkBridgeSizeException()
    println()

    InputView().readMoving()


}
