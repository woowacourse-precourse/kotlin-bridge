package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

private val validNum = "^[3-9]$|^[1][0-9]$|^[2][0]$".toRegex()
class InputView {

    fun readBridgeSize(): Int {
        println("다리 건너기 게임을 시작합니다.")
        println()
        println("다리의 길이를 입력해주세요.")
        var user = Console.readLine()
        if(!user.matches(validNum)){
            throw IllegalArgumentException("[ERROR] 입력 형식이 잘못 되었습니다.")
        }

        return user.toInt()
    }

    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        var upOrDown = Console.readLine()
        if(upOrDown == "U"){
            return "U"
        }
        if(upOrDown == "D"){
            return "D"
        }
        throw IllegalArgumentException("[ERROR] U 또는 D만 입력해주세요.")
    }

    fun readGameCommand(): String {
        println()
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        var upOrDown = Console.readLine()
        if(upOrDown == "R"){
            return "R"
        }
        if(upOrDown == "Q"){
            return "Q"
        }
        throw IllegalArgumentException("[ERROR] R 또는 Q만 입력해주세요.")
    }
}
