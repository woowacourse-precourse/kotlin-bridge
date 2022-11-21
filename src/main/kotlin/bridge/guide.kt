package bridge

class guide {
    fun moveresult(){
        OutputView().printResult()
    }
    fun retryresult(){
        OutputView().printResult2()
    }
    fun bridgeList(bridgecheck: String, bridgeUpList: MutableList<String>, bridgeDownList: MutableList<String>){
        val bridgechoose = guide().BridgeChoose()
        bridgeUpList.add(BridgeGame().BridgUp(bridgecheck, bridgechoose))
        bridgeDownList.add(BridgeGame().BridgDown(bridgecheck, bridgechoose))
        OutputView().printMap(bridgeUpList.joinToString("|"))
        OutputView().printMap(bridgeDownList.joinToString("|"))
    }

    fun Guide(): Int {
        OutputView().printGuide()
        return InputView().readBridgeSize()
    }
    fun restart(): String {
        OutputView().printRestartMsg()
        return InputView().readGameCommand()
    }

    fun BridgeChoose(): String {
        OutputView().printBridgeChoose()
        val a= InputView().readMoving()
        println(a)
        return a
    }
}