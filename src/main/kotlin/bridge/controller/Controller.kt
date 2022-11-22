package bridge.controller

import bridge.model.BridgeBoard
import bridge.model.BridgeGame
import bridge.utils.BridgeMaker
import bridge.utils.BridgeRandomNumberGenerator
import bridge.view.InputView
import bridge.view.OutputView

class Controller {
    private var bridgeBoard = BridgeBoard()
    private var board = bridgeBoard.board
    private lateinit var goalBridge : List<String>
    private lateinit var bridgeGame: BridgeGame
    private val generator = BridgeRandomNumberGenerator()
    private val input = InputView()
    private val output = OutputView()

    private var gameStatus = true

    fun startGame(){
        output.printStartMessage()
        goalBridge = BridgeMaker(generator).makeBridge(getBridgeSize())
        bridgeGame = BridgeGame(goalBridge, bridgeBoard)
        playGame()
    }

    private fun playGame(){
        while(gameStatus) {
            bridgeGame.move(getUserMoving())
            output.printMap(board)
            if(fail())
                break
            if(correct())
                endGame(true)
        }
    }

    private fun endGame(success: Boolean){
        gameStatus = false
        output.printResult(success, bridgeGame.attempts, bridgeBoard.board)
    }

    private fun getBridgeSize():Int{
        return try {
            input.readBridgeSize()
        }catch (e: IllegalArgumentException){
            output.printErr(e.message!!)
            getBridgeSize()
        }
    }

    private fun getUserMoving(): String{
        return try {
            input.readMoving()
        }catch (e: IllegalArgumentException){
            output.printErr(e.message!!)
            getUserMoving()
        }
    }

    private fun getGameCommand(): String{
        return try {
            input.readGameCommand()
        }catch (e: IllegalArgumentException){
            output.printErr(e.message!!)
            getGameCommand()
        }
    }

    private fun fail():Boolean{
        return if(bridgeBoard.board[0][bridgeBoard.board[0].size-1] == "X"
            || bridgeBoard.board[1][bridgeBoard.board[0].size-1] == "X") {
            gameStatus = false
            askRetry()
            true
        }else
            false
    }

    private fun askRetry(){
        if(getGameCommand() == "R"){
            gameStatus = true
            bridgeGame.retry(bridgeBoard)
            playGame()
        }else{
            endGame(false)
        }
    }

    private fun correct(): Boolean{
        if(bridgeBoard.board[0].size == goalBridge.size)
            if(bridgeBoard.board[0][bridgeBoard.board.size-1] == "O"
                || bridgeBoard.board[1][bridgeBoard.board.size-1] == "O" )
                return true
        return false
    }
}