package bridge

class BridgeGameStarter {

    companion object{
        lateinit var bridge : List<String>
        var moving = mutableListOf<String>()
        var success = "True"
    }

    fun setGame(){
        OutputView().printStart()
        bridge = BridgeGame().bridgeSetting()
    }

    fun startGame(){
        do{ OutputView().printSelection()
            val nextMoving = InputView().readMoving()
        } while(success == "True" && moving.size != bridge.size)
    }

}