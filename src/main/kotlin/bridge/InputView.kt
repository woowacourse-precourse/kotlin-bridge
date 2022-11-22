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
        println(UI.GET_BRIDGE_SIZE_MESSAGE)
        var number: String
        do {
            number = Console.readLine()
        } while (!ExceptionHandler.checkValidLength(number))
        return number.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(UI.GET_MOVE_MESSAGE)
        var location: String
        do {
            location = Console.readLine()
        } while (!ExceptionHandler.checkValidMoving(location))
        return location
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
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

    private fun String.toIntOrThrow(): Int {
        return requireNotNull(toIntOrNull()) { Message.InputViewEnum.INVALID_LENGTH }
    }

    enum class UI(vararg args: String) {
        START_MESSAGE("다리 건너기 게임을 시작합니다."),
        GET_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
        GET_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        GET_RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
        RESULT_MESSAGE("최종 게임 결과"),
        DETAIL_RESULT_MESSAGE("게임 성공 여부: %s\n총 시도한 횟수: %d");

        val messages: List<String> = args.toList()
        override fun toString() = messages.joinToString("\n")
    }
}
