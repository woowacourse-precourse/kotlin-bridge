package bridge

class GameSimulation {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()

    companion object{
        var size = 0
        var bool = true
        var retry = true
        var cnt = 0
    }

    fun gameSimulation() {
        gameStart()
        bridgeGame.initBridge(size)
        while(bool || retry){
            gameMoving()
            gameCheck()
            if(gameCorrectAnswer()){
                break
            }
        }
        gameTermination()
    }

    fun gameStart(){
        outputView.printGameStart()
        outputView.printBridgeLength()
        size = inputView.readBridgeSize()
    }

    fun gameMoving(){
        outputView.printSelectMoveToSpace()
        val movingKey = inputView.readMoving()
        bool = bridgeGame.move(movingKey)
        outputView.printBridge(bridgeGame.getUserBridge().getBridge(), bool)
        outputView.printMap()
        cnt += 1
    }

    fun gameCheck(){
        if(!bool){
            outputView.printSelectRetry()
            val retryingKey = inputView.readGameCommand()
            retry = bridgeGame.retry(retryingKey)
            outputView.printClearBridge()
            cnt = 0
        }
    }
    fun gameCorrectAnswer() : Boolean{
        if(cnt == size && bool){
            return true
        }
        return false
    }

    fun gameTermination(){
        outputView.printResult()
        outputView.printResult(bool, bridgeGame.getGameCount())
    }
}