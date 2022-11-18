package bridge

class playBridgeGameTest {
    val OV = OutputView()
    val IV = InputView()
    val BG = BridgeGame()
    var temp = listOf<String>()
    var cnt = 0
    val win = "성공"
    val lose = "실패"

    constructor(){
        OV.printStartGame()
        OV.inputBridgeLength()
    }

    fun bridgeGameStart() : List<String> {
        val size = IV.readBridgeSize()
        val bridge = BridgeMaker(bridgeNumberGenerator = BridgeRandomNumberGenerator()).makeBridge(size)
        println(bridge) // 나중에 지우면 됨
        return bridge
    }

    fun duringGame(bridge: List<String>, index: Int) {
        OV.chooseMove()
        var choose = IV.readMoving()
        temp = BG.buildMap(choose ,BG.move(choose, bridge, index))
//        println(temp)
//        println(temp[0])
//        println(temp[1])
        BG.mapBuilder1(temp[0], cnt)
        BG.mapBuilder2(temp[1], cnt)
        cnt+=1
    }




}