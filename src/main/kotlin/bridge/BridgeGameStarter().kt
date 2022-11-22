package bridge

class BridgeGameStarter() {

    companion object{
        lateinit var bridge : List<String>
    }

    fun setGame(){
        OutputView().printStart()
        bridge = BridgeGame().bridgeSetting()
    }

}