package bridge

class Guide {
    fun moveresult(){
        OutputView().printResult()
    }
    fun retryresult(){
        OutputView().printResult2()
    }

    fun guideInfo(): Int {
        OutputView().printGuide()
        return InputView().readBridgeSize()
    }
    fun restart(): String {
        OutputView().printRestartMsg()
        return InputView().readGameCommand()
    }
    fun bridgeList(bridgecheck: String, bridgeUpList: MutableList<String>, bridgeDownList: MutableList<String>){
        val bridgechoose = Guide().bridgeChoose()
        bridgeUpList.add(BridgeGame().bridgUp(bridgecheck, bridgechoose))
        bridgeDownList.add(BridgeGame().bridgDown(bridgecheck, bridgechoose))
        OutputView().printMap(bridgeUpList.joinToString("|"))
        OutputView().printMap(bridgeDownList.joinToString("|"))
    }
    fun bridgeChoose(): String {
        OutputView().printBridgeChoose()
        val chooseBridge= InputView().readMoving()
        println(chooseBridge)
        return chooseBridge
    }
}