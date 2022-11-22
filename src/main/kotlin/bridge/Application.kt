package bridge

fun inputWay() : String{
    val inputView = InputView()
    var way = "E"
    while (way == "E") way = inputView.readMoving()
    return way
}

fun failGame(bridge: List<String>, i: Int):Int{
    val inputView = InputView()
    val outputView = OutputView()
    outputView.printMapFalse(bridge, i)
    var again = "E"
    while(again == "E"){
        again = inputView.readGameCommand()
    }
    if (again == "R") return 1
    return 0
}

fun printBridgeMap(i : Int,bridge:List<String>):Int{
    val outputView = OutputView()
    var way = inputWay()
    val bridgeGame = BridgeGame()
    if (bridgeGame.move(i, bridge, way)) {
        outputView.printMap(bridge, i)
    } else {
        val reternNum = failGame(bridge,i)
        return reternNum
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

fun bridgeMake(size:Int): List<String>{
    val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
    val bridge = bridgeMaker.makeBridge(size)
    return bridge
}

fun BridgeGameMain() {
    val inputView = InputView()
    val outputView = OutputView()
    var size = -1
    while (size == -1) size = inputView.readBridgeSize()
    var bridge = bridgeMake(size)
    val bridgeGame = BridgeGame()
    val (finish,count) =  bridgeGame.retry(size,bridge)
    if (finish == 0) outputView.printResultFail(bridge,size-1,count)
    else outputView.printResult(bridge,size-1,count)
}



fun main() {
    println("다리건너기 게임을 시작합니다.")
    BridgeGameMain()
}
