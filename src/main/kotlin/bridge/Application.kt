package bridge

fun printBridgeMap(i : Int,bridge:List<String>):Int{
    val inputView = InputView()
    val outputView = OutputView()
    var way = "E"
    while (way == "E") way = inputView.readMoving()
    val bridgeGame = BridgeGame()
    if (bridgeGame.move(i, bridge, way)) {
        outputView.printMap(bridge, i)
    } else {
        outputView.printMapFalse(bridge, i)
        var again = inputView.readGameCommand()
        if (again == "R") return 1
        else return 0
    }
    return 2
}

fun BridgeGameing(size : Int,bridge : List<String>) : Int {
    for (i in 0 until size) {
        var printBridgeMapReturn = printBridgeMap(i,bridge)
       if(printBridgeMapReturn == 0|| printBridgeMapReturn == 1) return printBridgeMapReturn
    }
    return 2
}

fun BridgeGameMain() {
    val inputView = InputView()
    val outputView = OutputView()
    var size = -1
    while (size == -1) size = inputView.readBridgeSize()
    var bridgeNumberGenerator = BridgeRandomNumberGenerator()
    var bridgeMaker = BridgeMaker(bridgeNumberGenerator)
    var bridge = bridgeMaker.makeBridge(size)
    var finish = 1
    var count = 0
    while (finish == 1) {
        count++
        finish = BridgeGameing(size, bridge)
    }
    if (finish == 0) outputView.printResultFail(bridge,size-1,count)
    else outputView.printResult(bridge,size-1,count)
}



fun main() {
    println("다리건너기 게임을 시작합니다.")
    BridgeGameMain()
}
