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
        playGame()
    }

    private fun playGame(){
        bridgeBoard = BridgeBoard()
        board = bridgeBoard.board

        while(gameStatus) {

            move(input.readMoving())
            output.printMap(board)

            if(fail())
                break

            if(correct())
                endGame(true)
        }
    }

    private fun endGame(success: Boolean){
        gameStatus = false
        output.printResult(success, attempts, board)
    }


    fun move(moving: String) {
        if(goalBridge[board[0].size] == moving){
            bridgeBoard.updateBoard(true, moving)
        }else
            bridgeBoard.updateBoard(false, moving)
    }

    private fun fail():Boolean{
        return if(board[0][board[0].size-1] == "X" || board[1][board[0].size-1] == "X") {
            gameStatus = false
            retry()
            true
        }else
            false
    }

    private fun retry() {
        if(input.readGameCommand() == "R"){
            attempts++
            gameStatus = true
            playGame()
        }else{
            endGame(false)
        }
    }

    private fun correct(): Boolean{
        if(board[0].size == goalBridge.size)
            if(board[0][board.size-1] == "O" || board[1][board.size-1] == "O" )
                return true
        return false
    }
}
