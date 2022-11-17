package bridge

import camp.nextstep.edu.missionutils.Console.readLine

/*** 사용자로부터입력을받는역할을한다.*/
class InputView {
    /*** 다리의길이를입력받는다.*/
    fun readBridgeSize(): Int {
        val bridgeSize = readLine()
        return bridgeSize.toInt()
    }

    /*** 사용자가이동할칸을입력받는다.*/
    fun readMoving(): String {
        val moving = readLine()
        return moving
    }

    /*** 사용자가게임을다시시도할지종료할지여부를입력받는다.*/
    fun readGameCommand(): String {
        val gameCommand = readLine()
        return gameCommand
    }
}