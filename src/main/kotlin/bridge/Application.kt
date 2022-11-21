package bridge

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    val bridgeGame = BridgeGame()

    try {
        println("다리 건너기 게임을 시작합니다.")

        val bridgeSize = inputView.readBridgeSize()

        val answerBridge = bridgeMaker.makeBridge(bridgeSize)

        var count = 1

        while (true) {
            val bridge = mutableListOf<String>()
            var endGame = false
            while (true) {
                val movement = inputView.readMoving()
                bridgeGame.move(bridge, movement)

                outputView.printMap(bridge, answerBridge)

                when (bridgeGame.isDone(bridge, answerBridge)) {
                    BridgeGame.GameState.Doing -> Unit
                    BridgeGame.GameState.Win -> {
                        println("최종 게임 결과")
                        outputView.printMap(bridge, answerBridge)

                        outputView.printResult(true, count)
                        endGame = true
                        break
                    }
                    BridgeGame.GameState.Lose -> {
                        val retry = inputView.readGameCommand()
                        endGame = bridgeGame.retry(retry).not()

                        if (endGame) {
                            outputView.printResult(false, count)
                        }

                        break
                    }
                }
            }
            if (endGame) break
        }
    } catch (e: java.lang.IllegalArgumentException) {
        println(e.message)
    } catch (e: java.lang.IllegalStateException) {
        println(e.message)
    }
}