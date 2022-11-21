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
        println("\n다리의 길이를 입력해주세요.")
        val bridgeSize = Console.readLine()
        if (bridgeSize.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] 3 부터 20 사이의 숫자만 입력해주세요.")
        }
        if (bridgeSize.toInt() !in 3..20) {
            throw IllegalArgumentException("[ERROR] 3 부터 20 사이의 숫자만 입력해주세요.")
        }

        return bridgeSize.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("\n이동할 칸을 선택해 주세요. (위: U, 아래: D)")
        val moveSize = Console.readLine()

        if (moveSize.length != 1 || moveSize !in listOf("U", "D")) {
            throw IllegalArgumentException()
        }

        return moveSize
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("\n게임을 다시 시도할지 여부를입력해주세요. (재시도:R, 종료:Q)")
        val gameCommand = Console.readLine()
        if (gameCommand.length != 1 || gameCommand !in listOf("R", "Q")) {
            throw IllegalArgumentException()
        }
        return gameCommand
    }
}
