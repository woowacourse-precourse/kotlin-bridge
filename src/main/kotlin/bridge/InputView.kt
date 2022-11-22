package bridge

import java.lang.IllegalArgumentException
import kotlin.system.exitProcess

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        printStartGameMessage()
        var res : Int? = 0
        try {
            res = readLine()!!.toIntOrNull() ?: throw IllegalArgumentException()
        }
        catch (e: IllegalArgumentException) {
            println("$ERROR_MESSAGE 정수를 입력하세요.")
            exitProcess(1)
        }
        return res!!
    }

    fun printStartGameMessage() {
        println("다리 건너기 게임을 시작합니다.  \n" +
                "  \n" +
                "다리의 길이를 입력해주세요.")
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        printMovingMessage()
        var res : String = readLine()!!
        try {
            updownCheck(res)
        }
        catch (e: IllegalArgumentException) {
            println("$ERROR_MESSAGE U 또는 D를 입력하세요.")
            exitProcess(1)
        }
        return res
    }

    fun printMovingMessage() {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D) ")
    }

    fun updownCheck(inputStr : String?) {
        if (inputStr !is String) throw IllegalArgumentException()
        else if ( !inputStr.equals("U")  || !inputStr.equals("D")) throw IllegalArgumentException()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        printGameCommand()
        var res : String? = ""
        try {
            res = readLine()
            retryCheck(res)
        }
        catch (e: IllegalArgumentException) {
            println("$ERROR_MESSAGE R 또는 Q를 입력하세요.")
            exitProcess(1)
        }
        return res!!
    }

    fun printGameCommand() {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    }
    fun retryCheck(inputStr : String?) {
        if (inputStr.equals("R"))
        else if (inputStr.equals("Q"))
            exitProcess(0)
        else throw IllegalArgumentException()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
