package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        try {
            println("다리의 길이를 입력해주세요.")
            val temp = Console.readLine() ?: "-1"

            val sizeBridge = temp.toInt()

            if (sizeBridge < 3 || sizeBridge > 20)
                throw IllegalArgumentException("[ERROR] 숫자가 다리의 범위 밖입니다")

            return sizeBridge
        }catch (e: NumberFormatException){
            println("[ERROR] 숫자가 아닙니다")
        }
        return 0
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")

        val temp = Console.readLine()   ?:"A"
        if (temp != "U" && temp != "D")
            throw IllegalArgumentException("[ERROR] 올바른 입력을 하세요")

        return temp
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val temp = Console.readLine() ?: "A"

        if (temp != "R" && temp != "Q")
            throw IllegalArgumentException("[ERROR] 올바른 입력을 하세요")

        return temp
    }
}
