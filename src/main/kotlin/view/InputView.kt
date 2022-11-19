package view

import util.Exception
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
object InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return try {
            checkBridgeSize()
        } catch (e: IllegalArgumentException) {
            readBridgeSize()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return try {
            checkMoving()
        } catch (e: IllegalArgumentException) {
            readMoving()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return try {
            checkGameCommand()
        } catch (e: IllegalArgumentException) {
            readGameCommand()
        }
    }

    private fun checkMoving(): String {
        val line = Console.readLine()
        Exception.validateMovingCommand(line)
        return line
    }

    private fun checkBridgeSize(): Int {
        val line = Console.readLine()
        Exception.validateNumber(line)
        Exception.validateBridgeSizeRange(line.toInt())
        return line.toInt()
    }

    private fun checkGameCommand(): String {
        val line = Console.readLine()
        Exception.validateGameCommand(line)
        return line
    }
}
