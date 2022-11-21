package bridge

//processGame 위치 바꾸자


fun main() {
    val processor = Processor(
        BridgeGame(BridgeMaker(BridgeRandomNumberGenerator())),
        InputView(InputValidator()),
        OutputView())

    processor.processGame()
}


