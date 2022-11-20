package bridge.controller

import bridge.model.BridgeBoard
import bridge.utils.BridgeMaker
import bridge.utils.BridgeRandomNumberGenerator
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGame {
    private lateinit var bridgeBoard  : BridgeBoard
    private lateinit var board : MutableList<MutableList<String>>
    private lateinit var goalBridge : List<String>
    private val generator = BridgeRandomNumberGenerator()
    private val input = InputView()
    private val output = OutputView()

    private var attempts = 1
    private var gameStatus = true

    fun startGame(){
        output.printStartMessage()
        goalBridge = BridgeMaker(generator).makeBridge(input.readBridgeSize())
    }

    fun move(moving: String) {
        if(goalBridge[board[0].size] == moving){
            bridgeBoard.updateBoard(true, moving)
        }else
            bridgeBoard.updateBoard(false, moving)
    }


    fun retry() {}
}
