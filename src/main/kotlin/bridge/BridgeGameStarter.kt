package bridge

class BridgeGameStarter {

    companion object{
        lateinit var bridge : List<String>
        var moving = mutableListOf<String>()
        var success = "True"
        var cnt = 0
    }

    fun setGame(){
        OutputView().printStart()
        bridge = BridgeGame().bridgeSetting()
    }

    fun startGame(){
        cnt++
        do{ OutputView().printSelection()
            val nextMoving = InputView().readMoving()
            var checkMoving = BridgeGame().move(nextMoving, bridge)
            OutputView().printMap(checkMoving)
        } while(success == "True" && moving.size != bridge.size)
    }

}