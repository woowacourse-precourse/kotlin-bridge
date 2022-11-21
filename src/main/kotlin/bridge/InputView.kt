package bridge

import camp.nextstep.edu.missionutils.Console

const val ERROR_TAG = "[ERROR]"
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * @brief 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        while(true) {
            println("다리의 길이를 입력해주세요.")
            val size = Console.readLine()
            runCatching {
                validateBridgeSize(size)
            }.onSuccess { return size.toInt() }.onFailure {println(it.message) }
        }
    }

    /**
     * @brief 다리의 길이가 유효한지 확인한다.
     * @return 유효한 경우, int로 변환한 다리 길이를 반환하고 아닌 경우 Exception을 던진다.
     */
    private fun validateBridgeSize(size: String): Int {
        if (size.toIntOrNull() == null) throw IllegalArgumentException("$ERROR_TAG 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
        if (size.toInt() < 3 || size.toInt() > 20) throw IllegalArgumentException("$ERROR_TAG 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
        return size.toInt()
    }

    /**
     * @brief 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while(true) {
            println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
            val moving = Console.readLine()
            runCatching{
                validateMoving(moving)
            }.onSuccess{return moving}.onFailure{println(it.message)}
        }
    }
    /**
     * @brief 이동할 칸에 대한 입력이 유효한지 확인한다.
     * @return 입력이 유효한 경우, 사용자의 입력을 반환하고 아닌 경우 Exception을 던진다.
     */
    private fun validateMoving(moving: String): String {
        if(moving != "U" && moving != "D") throw IllegalArgumentException("$ERROR_TAG 이동할 칸은 U 혹은 D로 표현되어야 합니다.")
        return moving
    }

    /**
     * @brief 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while(true) {
            println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
            val gameCommand = Console.readLine()
            runCatching{
                validateGameCommand(gameCommand)
            }.onSuccess{return gameCommand}.onFailure{println(it.message)}
        }
    }

    /**
     * @brief 게임 종료 여부에 대한 입력이 유효한지 확인한다.
     * @return 입력이 유효한 경우, 사용자의 입력을 반환하고 아닌 경우 Exception을 던진다.
     */
    private fun validateGameCommand(gameCommand: String): String {
        if(gameCommand != "R" && gameCommand != "Q") throw IllegalArgumentException("$ERROR_TAG 종료 여부는 R 혹은 Q로 표현되어야 합니다.")
        return gameCommand
    }
}
