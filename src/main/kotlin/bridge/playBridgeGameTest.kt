package bridge

class playBridgeGameTest {
    val OV = OutputView()
    val IV = InputView()
    val BG = BridgeGame()
    var temp = listOf<String>()
    var gameTry = 1
    var cnt = 0
    var select = ""
    var map1 = ""
    var map2 = ""
    val win = "성공"
    val lose = "실패"
    var value = 0
    var bridgeSize = 0

    constructor(){
        OV.printStartGame()
        OV.inputBridgeLength()
    }

    fun bridgeGameStart() : List<String> {
        val size = IV.readBridgeSize()
        val bridge = BridgeMaker(bridgeNumberGenerator = BridgeRandomNumberGenerator()).makeBridge(size)
        bridgeSize=bridge.size
        println(bridge) // 나중에 지우면 됨
        return bridge
    }

    fun duringGame(bridge: List<String>, index: Int) : Int{
        OV.chooseMove()
        var choose = IV.readMoving()
        temp = BG.buildMap(choose ,BG.move(choose, bridge, index))
        map1=BG.mapBuilder1(temp[0], cnt)
        map2=BG.mapBuilder2(temp[1], cnt)
        OV.printMap(map1)
        OV.printMap(map2)
        cnt+=1
        if (map1.contains("X")||map2.contains("X")) regameOrQuit()
        return indexUpOrStay(index)
    }

    fun duringGame2(index: Int){
        println()
        if (index==bridgeSize) winTheGame()
    }


    fun indexUpOrStay(index : Int) : Int{
        if ((map1.contains("X")||map2.contains("X"))&&select=="R") {
            return 0
        }
        else if ((map1.contains("X")||map2.contains("X"))&&select=="Q") {
            return bridgeSize
        }
        if (!map1.contains("X")||!map2.contains("X")) {
            value = index+1
        }
        return value
    }

    fun winTheGame(){
        OV.printResult()
        OV.printMap(map1)
        OV.printMap(map2)
        OV.printResult1(win, gameTry)
    }

    fun regameOrQuit(){
        OV.askRegameOrQuit()
        select=IV.readGameCommand()
        if (select=="R") {
            BG.retry()
            cnt=0
            gameTry+=1
        } else if (select=="Q") {
            OV.printResult()
            OV.printMap(map1)
            OV.printMap(map2)
            OV.printResult1(lose, gameTry)
        }
    }


}