package bridge

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readBridgeSize() = Console.readLine().toInt()
    
    fun readMoving(): String = Console.readLine()
    
    fun readGameCommand(): String = Console.readLine()
}
