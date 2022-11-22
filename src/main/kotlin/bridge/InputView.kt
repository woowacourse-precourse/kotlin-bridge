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
        println("다리 건너기 게임을 시작합니다.")
        while (true) {
            println("다리의 길이를 입력해주세요.")
            val readSize = numberCheck(Console.readLine())
            if (readSize !in 3..20)
                println("[ERROR]: 3이상 20이하 숫자만 입력해주세요.")
            if (readSize in 3..20)
                return readSize
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while (true){
            println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
            val step = Console.readLine()
            if (!(step == "U" || step == "D"))
                println("[ERROR]: 'U'(위) 혹은 'D'(아래) 값만 입력 가능합니다.")
            if (step == "U" || step == "D")
                return step
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while (true){
            println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
            val regame = Console.readLine()
            if (!(regame == "R" || regame == "Q"))
                println("[ERROR]: 'R'(재시도) 혹은 'Q'(종료) 값만 입력 가능합니다.")
            if (regame == "R" || regame == "Q")
                return regame
        }
    }

    fun numberCheck(number:String): Int {
        return try {
            number.toInt()
        } catch (e: IllegalArgumentException) {
            0
        }
    }
}
