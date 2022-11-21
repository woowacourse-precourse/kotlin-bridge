package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val intRegex = Regex("\\d+")
    private val movementRegex = Regex("[U|D]")
    private val endingCommandRegex = Regex("[R|Q]")

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        val bridgeLengthString = Console.readLine()

        if (intRegex.matches(bridgeLengthString).not()) {
            throw java.lang.IllegalArgumentException("[ERROR] 다리의 길이는 숫자 형태 이어야 합니다.")
        }

        val bridgeLength = bridgeLengthString.toInt()
        if ((bridgeLength in 3..20).not()) {
            throw java.lang.IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
        }

        return bridgeLength
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val movement = Console.readLine()

        if (movementRegex.matches(movement).not()) {
            throw java.lang.IllegalArgumentException("[ERROR] 이동은 U 혹은 R 이어야 합니다.")
        }

        return movement
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val endingCommand = Console.readLine()

        if (endingCommandRegex.matches(endingCommand).not()) {
            throw java.lang.IllegalArgumentException("[ERROR] 종료 입력은 R 혹은 Q 이어야 합니다.")
        }

        return endingCommand
    }
}
