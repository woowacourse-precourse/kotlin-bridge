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
        println(InputMessage.BRIDGE_START.message)
        while (true) {
            println(InputMessage.BRIDGE_LENGTH.message)
            val readSize = numberCheck(Console.readLine())
            if (readSize !in 3..20)
                println(Error.ERROR_LENGTH.error)
            if (readSize in 3..20)
                return readSize
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while (true) {
            println(InputMessage.BRIDGE_MOVE.message)
            val step = Console.readLine()
            if (!(step == "U" || step == "D"))
                println(Error.ERROR_MOVE.error)
            if (step == "U" || step == "D")
                return step
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while (true) {
            println(InputMessage.BRIDGE_RESTART.message)
            val regame = Console.readLine()
            if (!(regame == "R" || regame == "Q"))
                println(Error.ERROR_RESTART.error)
            if (regame == "R" || regame == "Q")
                return regame
        }
    }

    fun numberCheck(number: String): Int {
        return try {
            number.toInt()
        } catch (e: IllegalArgumentException) {
            0
        }
    }

    enum class InputMessage(val message: String){
        BRIDGE_START("다리 건너기 게임을 시작합니다."),
        BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
        BRIDGE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        BRIDGE_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    }

    enum class Error(val error: String){
        ERROR_LENGTH("[ERROR] 3이상 20이하 숫자만 입력해주세요."),
        ERROR_MOVE("[ERROR] 'U'(위) 혹은 'D'(아래) 값만 입력 가능합니다."),
        ERROR_RESTART("[ERROR] 'R'(재시도) 혹은 'Q'(종료) 값만 입력 가능합니다.")
    }
}
