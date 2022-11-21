package bridge

fun BridgeGameing(size : Int,bridge : List<String>) : Int {
    val inputView = InputView()
    val outputView = OutputView()
    for (i in 0 until size) {
        var way = "E"
        while (way == "E") {
            way = inputView.readMoving()
        }
        val bridgeGame = BridgeGame()


        if (bridgeGame.move(i, bridge, way)) {
            outputView.printMap(true, bridge, i)
        } else {
            outputView.printMap(false, bridge, i)
            var again = inputView.readGameCommand()
            if (again == "R") {
                return 1
            }
            else {
                return 0
            }
        }
    }
    return 2
}

fun BridgeGameMain() {
    val inputView = InputView()
    val outputView = OutputView()
    var size = -1
    while(size ==-1) {
        size = InputView.readBridgeSize()
    }
    var bridgeNumberGenerator = BridgeRandomNumberGenerator()
    var bridgeMaker = BridgeMaker(bridgeNumberGenerator)
    var bridge = bridgeMaker.makeBridge(size)
    for(i in 0 until size){
        var way = "E"
        while(way == "E") {
            way = InputView.readMoving()
        }

    }
}

fun main() {
    println("다리건너기 게임을 시작합니다.")
    BridgeGameMain()
}
