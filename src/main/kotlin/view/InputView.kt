package view

import camp.nextstep.edu.missionutils.Console
import exception.ExceptionCheck
import util.Game

class InputView {
    fun readBridgeSize(): Int {
        println(Game.BRIDGE_LENGTH_INPUT.message)
        val bridgeSize = Console.readLine()
        return ExceptionCheck().checkValidBridgeLengthInput(bridgeSize)
    }

    fun readMoving(): String {
        println(Game.MOVE_INPUT.message)
        val moveLetter = Console.readLine()
        return ExceptionCheck().checkValidMoveLetterInput(moveLetter)
    }

    fun readGameCommand(): String {
        println(Game.RETRY_INPUT.message)
        val gameCommend = Console.readLine()
        return ExceptionCheck().checkValidRetryLetterInput(gameCommend)
    }
}
