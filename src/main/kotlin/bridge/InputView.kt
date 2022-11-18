package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val output = OutputView()

    fun readBridgeSize(): Int {
        output.printBridgeLength()

        return try {
            getBridgeSize()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readBridgeSize()
        }
    }
    
    fun readMoving(): String {
        output.printSelectBlock()

        return try {
            getMoving()
        }
        catch (e: IllegalArgumentException) {
            println(e.message)
            readMoving()
        }
    }

    fun readGameCommand(): String {
        output.printRestart()

        return try {
            getGameCommand()
        }
        catch (e: IllegalArgumentException) {
            println(e.message)
            readGameCommand()
        }
    }

    private fun getBridgeSize(): Int {
        val bridgeSize: Int
        try {
            bridgeSize = Console.readLine().toInt()
            if (bridgeSize !in 3..20) throw IllegalArgumentException("[ERROR] 다리 길이는 3과 20 사이여야 합니다.")
        }
        catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 입력은 숫자로만 이루어져야 합니다.")
        }

        return bridgeSize
    }

    private fun getMoving(): String {
        val selectMove = Console.readLine()
        if(selectMove != "U" && selectMove != "D") throw IllegalArgumentException("이동할 칸은 U 또는 D를 입력 가능합니다..")

        return selectMove
    }

    private fun getGameCommand(): String {
        val isRestart = Console.readLine()
        if(isRestart == "R" || isRestart == "Q") return isRestart
        throw IllegalArgumentException("재시작 여부는 R 또는 Q만 입력 가능합니다.")
    }
}