package bridge

import bridge.ui.InputView
import bridge.ui.OutputView

class Player {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val bridgeState = BridgeState()

    companion object{
        const val SUCCESS = "성공"
        const val FAIL = "실패"
        const val RETRY = true
        const val QUIT = false
    }
    fun playGame(){
        val size = inputView.readBridgeSize()
        val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        val bridge = BridgeMaker(bridgeRandomNumberGenerator).makeBridge(size)
        val isSuccess = crossBridge(bridge)
        outputView.printSuccess(isSuccess)
    }

    private fun crossBridge(bridge:List<String>):String{
        var count = 0
        var isSuccess = FAIL
        var command = RETRY
        while(command && isSuccess == FAIL){
            count++
            if(bridgeState.compare(bridge)){
                isSuccess = SUCCESS
                break
            }
            if(!BridgeGame().retry(inputView.readGameCommand())) command = QUIT
        }
        outputView.printCount(count)
        return isSuccess
    }
}