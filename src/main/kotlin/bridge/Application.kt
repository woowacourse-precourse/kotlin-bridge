package bridge

fun main() {

    val inputView = InputView()
    val outputView = OutputView()
    val bridgeGame = BridgeGame()

    var s = 0

    println("다리 건너기 게임을 시작합니다.")
    println("")

    bridgeGame.size = inputView.readBridgeSize()
    bridgeGame.answerList = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeGame.size) as MutableList<String>

    var command = ""

    while(true) {

        command = inputView.readMoving()

        s = bridgeGame.move(command)
        outputView.printMap(bridgeGame)

        if(bridgeGame.checkStep()){

            bridgeGame.idx++
            if (bridgeGame.idx == bridgeGame.size) {
                bridgeGame.success = 1
                break
            }


        }else{
            command = inputView.readGameCommand()
            if(command == "R") bridgeGame.retry()
            if(command == "Q") break
        }
    }
    outputView.printResult(bridgeGame)
}


