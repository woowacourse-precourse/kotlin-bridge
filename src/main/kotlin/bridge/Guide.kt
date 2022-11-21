package bridge

class Guide {
    fun guideInfo(): Int {
        OutputView().printGuide()
        return InputView().readBridgeSize()
    }
    fun restart(): String {
        OutputView().printRestartMsg()
        return InputView().readGameCommand()
    }
    fun successGuideMsg(){
        OutputView().printSuccessResult()
    }
    fun failGuideMsg(){
        OutputView().printFailResult()
    }
    fun bridgeList(bridgeCheck: String, bridgeUpList: MutableList<String>, bridgeDownList: MutableList<String>){
        val bridgeChoose = Guide().selectBridgeGuide()
        bridgeUpList.add(BridgeGame().bridgUp(bridgeCheck, bridgeChoose))
        bridgeDownList.add(BridgeGame().bridgDown(bridgeCheck, bridgeChoose))
        OutputView().printMap(bridgeUpList.joinToString("|"))
        OutputView().printMap(bridgeDownList.joinToString("|"))
    }
    fun selectBridgeGuide(): String {
        OutputView().printBridgeChoose()
        val chooseBridge= InputView().readMoving()
        println(chooseBridge)
        return chooseBridge
    }
}