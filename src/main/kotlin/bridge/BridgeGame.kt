package bridge

import util.Game
import view.InputView
import view.OutputView

class BridgeGame {
    fun startGame(bridgeSize: Int, bridgeLetter: List<String>): Boolean{
        val resultBridge: MutableList<Pair<String, String>> = mutableListOf()
        for(i in 0 until bridgeSize){
            val moveLetter = InputView().readMoving()
            val result = move(bridgeLetter[i], moveLetter)
            resultBridge.add(Pair(moveLetter, result))
            OutputView().printMap(resultBridge)
            if(result == "X"){
                return retry()
            }
        }
        OutputView().printResult(resultBridge)
        isSucceed(bridgeLetter, resultBridge)
        return false
    }

    private fun move(bridgeLetter: String, moveLetter: String): String {
        var result = " "
        if (bridgeLetter != moveLetter) {
            result = "X"
            return result
        }
        result = "O"
        return result
    }

    private fun retry(): Boolean {
        val userInput = InputView().readGameCommand()
        return userInput == "R"
    }

    private fun isSucceed(bridgeLetter: List<String>, resultBridge: MutableList<Pair<String, String>>){
        if(bridgeLetter.size == resultBridge.size){
            println("${Game.SUCCESS_OR_NOT.message}${Game.SUCCESS.message}")
        } else {
            println("${Game.SUCCESS_OR_NOT.message}${Game.FAIL.message}")
        }

    }
}
