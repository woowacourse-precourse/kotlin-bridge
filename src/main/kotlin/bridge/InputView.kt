package bridge

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        var bridgesize = Console.readLine().toIntOrNull() ?: 0
        println("")
        kotlin.runCatching { if(!(bridgesize in 3 .. 20)) throw IllegalArgumentException ("[ERROR] : 3 ~ 20 사이 숫자로 입력해 주세요.")}
            .onFailure { println ("[ERROR] : 3 ~ 20 사이 숫자로 입력해 주세요.") }
        return (bridgesize)
    }

    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val Movinguser = Console.readLine()
        kotlin.runCatching {if( !(Movinguser == "U" || Movinguser == "D")) throw IllegalArgumentException ("[ERROR] : U 와 D 만 입력해 주세요.")}
            .onFailure { println("[ERROR] : U 와 D 만 입력해 주세요.") }
        return Movinguser
    }

    fun readGameCommand(): String {
        println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val restartgame = Console.readLine()
        kotlin.runCatching { if (!(restartgame == "R" ||  restartgame == "Q")) throw IllegalArgumentException ("[ERROR] : R 과 Q 만 입력해 주세요.") }
            .onFailure{ println("[ERROR] : R 과 Q 만 입력해 주세요.")}
        return restartgame
    }
}