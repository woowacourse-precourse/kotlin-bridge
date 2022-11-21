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
    fun bridgeList( bridgeUpList: MutableList<String>, bridgeDownList: MutableList<String>){

        OutputView().printMap(bridgeUpList.joinToString("|"))
        OutputView().printMap(bridgeDownList.joinToString("|"))
    }

    fun success(index: Int, checkBridge: List<String>){
        if(index==checkBridge.size-1) OutputView().printLastGame()

    }
    fun fail(){
         OutputView().printLastGame()
    }
    fun selectBridgeGuide(): String {
        OutputView().printBridgeChoose()
        val chooseBridge= InputView().readMoving()
        println(chooseBridge)
        return chooseBridge
    }
}