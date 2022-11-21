package bridge

import bridge.ui.InputView
import bridge.ui.OutputView

class Player {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val bridgeState = BridgeState()
    private var isSuccess = FAIL
    private var command = RETRY
    private var count = 0

    companion object{
        const val SUCCESS = "성공"
        const val FAIL = "실패"
        const val RETRY = true
        const val QUIT = false
    }
    fun playGame(){
        val size = inputView.readBridgeSize()
        val bridge = Bridge(size)
        crossBridge(bridge)
    }

    private fun crossBridge(bridge: Bridge){
        while(command && isSuccess == FAIL){
            count++
            if(bridgeState.compare(bridge)){
                isSuccess = SUCCESS
                break
            }
            if(!BridgeGame().retry(inputView.readGameCommand())) command = QUIT
        }
        outputView.printStats(count,isSuccess)
    }
}