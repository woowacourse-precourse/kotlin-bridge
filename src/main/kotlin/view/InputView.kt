package view

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class InputView {

    fun readBridgeSize(): String {
        println("다리의 길이를 입력해주세요.")
        val bridgeSize = Console.readLine()
        println()
        return bridgeSize
    }

    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        return Console.readLine()
    }

    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        return Console.readLine()
    }

    fun inputValidCommand(): String {
        val command = readGameCommand()
        require(command == "R" || command == "Q") { "[ERROR] \"R\" 이나 \"Q\"를 입력해주세요." }
        return command
    }

    fun inputValidMove(): String {
        val move = readMoving()
        require(move == "U" || move == "D") { "[ERROR] \"U\" 나 \"D\"를 입력해주세요." }
        return move
    }

    fun inputValidBridgeSize(): Int {
        var bridgeSize = 0
        try {
            bridgeSize = readBridgeSize().toInt()
            require(bridgeSize in 3..20) { "[ERROR] 3이상 20이하 숫자를 입력해주세요." }
        } catch (exception: IllegalArgumentException) {
            print("[ERROR] 숫자만 입력해주세요.")
        }
        return bridgeSize
    }
}
