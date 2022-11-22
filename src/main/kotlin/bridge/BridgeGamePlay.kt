package bridge

class BridgeGamePlay {
    var bridge : List<String> = listOf()
    var location = 0
    var count = 1
    var retryCommand :String = ""
    var moveCommand :String = ""
    var endOrNot = false
    var successOrNot = false

    fun startGame(){
        println("다리 건너기 게임을 시작합니다.")
        val bridgeSize = getBridgeSize()
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        playGame()
        result()
    }

    private fun result() {
        println("최종 게임 결과")
        OutputView().printMap(bridge, location, moveCommand)
        OutputView().printResult(successOrNot, count)
    }

    private fun getBridgeSize(): Int {
        println("\n다리의 길이를 입력해주세요.")
        return InputView().readBridgeSize()
    }

    private fun playGame(){
        do{
            moveCommand = InputView().readMoving()
            OutputView().printMap(bridge, location, moveCommand)
            if(!BridgeGame().move(bridge, location, moveCommand))
                checkRetry()
            location ++
        }while(!endOrNot)
    }

    private fun checkRetry() {
        retryCommand = InputView().readGameCommand()
        if(retryCommand == "R"){
            count++
            location = -1
        }else if(retryCommand == "Q"){
            endOrNot = true
            location -= 1
        }



    }



}