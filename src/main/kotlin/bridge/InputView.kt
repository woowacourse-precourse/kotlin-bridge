package bridge

import camp.nextstep.edu.missionutils.Console.readLine

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println("다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.")

        val sizeString = readLine()
        numberError(sizeString)

        val sizeNumber: Int = sizeString.toInt()
        rangeError(sizeNumber)

        return sizeNumber
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)")

        return readLine()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        return readLine()
    }

    private fun checkNumber(string: String): Boolean {
        for (i in string.indices) {
            val temp = string.elementAt(i)
            if (temp.code < 48 || temp.code > 57) {
                return false
            }
        }
        return true
    }

    private fun numberError(sizeString: String) {
        if (!checkNumber(sizeString)) {
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
            throw NoSuchElementException()
        }
    }

    private fun rangeError(size: Int) {
        if (size !in 3..20) {
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
            throw NoSuchElementException()
        }
    }
}
