package bridge

class GameSimulator {
    companion object {
        private val inputView = InputView()
        private val outputView = OutputView()
        private val bridgeGame = BridgeGame()
        private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        private var gameFinishFlag = false
        private var tryCount = 0
        fun run() {
            initLoad()
            gameStart()
            outputView.printResult(bridgeGame.getUserInput(), bridgeGame.getBridge(), tryCount)
        }

        private fun gameStart(){
            while (!gameFinishFlag) {
                startRound()
            }
        }
        private fun startRound(){
            movingStep()
            gameFinishFlag = bridgeGame.checkIsGameFinish()
        }

        private fun initForRestart(){
            tryCount++
            bridgeGame.initUserInput()
        }

        private fun initLoad(){
            outputView.printOpeningMessage()
            bridgeGame.loadBridge(bridgeMaker.makeBridge(inputView.readBridgeSize()))
            tryCount++
        }

        private fun movingStep(){
            if (bridgeGame.move(inputView.readMoving())) {
                outputView.printMap(bridgeGame.getUserInput(), bridgeGame.getBridge())
            } else {
                restartStep()
            }
        }

        private fun restartStep(){
            if(bridgeGame.retry(inputView.readGameCommand())){
                initForRestart()
            }
            else{
                gameFinishFlag= true
            }
        }

    }
}