package bridge

class BridgeGamePlay {
    var bridge : List<String> = listOf()
    var location = 0
    var count = 1
    var retryCommand :String = ""

    fun startGame(){
        println("다리 건너기 게임을 시작합니다.")
        val bridgeSize = getBridgeSize()
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        playGame()
        OutputView().printResult()
    }

    private fun getBridgeSize(): Int {
        println("\n다리의 길이를 입력해주세요.")
        return InputView().readBridgeSize()
    }

    private fun playGame(){
        do{
            var moveCommand = InputView().readMoving()
            if(BridgeGame().move() == false)
                checkRetry()
            location ++
        }while(location < bridge.size)
    }

    private fun checkRetry() {
        retryCommand = InputView().readGameCommand()
        if(retryCommand == "R"){
            count++
            location = -1
        }else if(retryCommand == "Q")
            location = bridge.size-1

    }



}