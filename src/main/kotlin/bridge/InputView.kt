package bridge

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println("다리 건너기 게임을 시작합니다.\n다리의 길이를 입력해주세요.")
        val input = readLine() ?: throw IllegalArgumentException()
        try {
            input.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
        return input.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")

        val input = readLine() ?: throw IllegalArgumentException()

        if(input != "U" && input != "D") {
            throw IllegalArgumentException()
        }

        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")

        val input = readLine() ?: throw IllegalArgumentException()

        if(input != "R" && input != "Q") {
            throw IllegalArgumentException()
        }

        return input
    }
}