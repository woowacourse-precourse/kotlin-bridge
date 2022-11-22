package bridge

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readBridgeSize(): Int {
        println(UI.GET_BRIDGE_SIZE_MESSAGE)
        var number: String
        do {
            number = Console.readLine()
        } while (!ExceptionHandler.checkValidLength(number))
        return number.toInt()
    }

    fun readMoving(): String {
        println(UI.GET_MOVE_MESSAGE)
        var location: String
        do {
            location = Console.readLine()
        } while (!ExceptionHandler.checkValidMoving(location))
        return location
    }

    fun readGameCommand(): String {
        println(UI.GET_RETRY_MESSAGE)
        var restart: String
        do {
            restart = Console.readLine()
        } while (!ExceptionHandler.checkValidRestart(restart))
        return restart
    }

    fun startGame() {
        println(UI.START_MESSAGE)
    }

    enum class UI(vararg args: String) {
        START_MESSAGE("다리 건너기 게임을 시작합니다."),
        GET_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
        GET_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        GET_RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        private val messages: List<String> = args.toList()
        override fun toString() = messages.joinToString("\n")
    }
}
