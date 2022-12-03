package bridge

class BridgeGameApp {
        val bridgeGame = BridgeGame()
        lateinit var compareData:List<String>
        val output = OutputView()
    fun playGame(){
        output.printData(output.startGame())
        val bridgeSize = InputView().readBridgeSize()
        if(bridgeSize==-1)
            return
        val bridgeData = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        while(true){
            if(playGameLoop(bridgeSize, bridgeData)) break
        }
    }
    fun playGameLoop(bridgeSize: Int, bridgeData:List<String>): Boolean{
            for(i in 0 until bridgeSize){
                answerBridge(bridgeData)
                if(compareData[compareData.size-1]=="UX" || compareData[compareData.size-1]=="DX"){
                    if(!isNotAnswer()) return true
                    if(isNotAnswer()) return false
                }
            }
            output.printData(output.printResult(bridgeGame.tryGame,true, bridgeGame.resultToString(compareData)))
            return true
    }
    fun answerBridge(bridgeData:List<String>){
        bridgeGame.move(InputView().readMoving())
        compareData = bridgeGame.compareAnswer(bridgeData)
        output.printData(output.printMap(bridgeGame.resultToString(compareData)))
    }

    fun isNotAnswer(): Boolean{
            bridgeGame.retry()
            val command = InputView().readGameCommand()
            if(command == "Q"){
                output.printData(output.printResult(bridgeGame.tryGame,false, bridgeGame.resultToString(compareData)))
                return false
            }
            return true
    }
}