package bridge

import camp.nextstep.edu.missionutils.Console
import util.Error
import util.Messages

private val validNum = "^[3-9]$|^[1][0-9]$|^[2][0]$".toRegex()
class InputView {

    // 다리 길이
    fun readBridgeSize(): Int {
        println(Messages.START_GAME)
        println()
        println(Messages.INPUT_LENGTH)
        var user = Console.readLine()
        if(!user.matches(validNum)){
            throw IllegalArgumentException(Error.WRONG_LENGTH)
        }

        return user.toInt()
    }

    fun readMoving(): String {
        println(Messages.SELECT_BRIDGE)
        var upOrDown = Console.readLine()
        if(upOrDown == "U"){
            return "U"
        }
        if(upOrDown == "D"){
            return "D"
        }
        throw IllegalArgumentException(Error.WRONG_UP_OR_DOWN)
    }

    fun readGameCommand(): String {
        println()
        println(Messages.RETRY_OR_QUIT)
        var upOrDown = Console.readLine()
        if(upOrDown == "R"){
            return "R"
        }
        if(upOrDown == "Q"){
            return "Q"
        }
        throw IllegalArgumentException(Error.WRONG_RESTART_OR_QUIT)
    }
}
