package bridge

import camp.nextstep.edu.missionutils.Console.readLine

/*** 사용자로부터입력을받는역할을한다.*/
class InputView {
    /*** 다리의길이를입력받는다.*/
    fun readBridgeSize(): Int {
        try{
            val bridgeSize = readLine()
            if(!isNumeric(bridgeSize)) {
                throw IllegalArgumentException("[ERROR]")
            }
                return bridgeSize.toInt()
        }catch (e: IllegalArgumentException){
            println(e.message)
            return readBridgeSize()
        }
    }
    // 숫자인지 물어보는 함수
    fun isNumeric(s: String): Boolean {
        return s.chars().allMatch { Character.isDigit(it) }
    }

    /*** 사용자가이동할칸을입력받는다.*/
    fun readMoving(): String {
        try {
            val moving = readLine()
            if (moving!="U" && moving!="D") {
                throw IllegalArgumentException("[ERROR]")
            }
            return moving
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readMoving()
        }
    }

    /*** 사용자가게임을다시시도할지종료할지여부를입력받는다.*/
    fun readGameCommand(): String {
        try{
            val gameCommand = readLine()
            if (gameCommand!="R" && gameCommand!="Q") {
                throw IllegalArgumentException("[ERROR]")
            }
            return gameCommand
        }catch (e: IllegalArgumentException){
            println(e.message)
            return readGameCommand()
        }
    }
}