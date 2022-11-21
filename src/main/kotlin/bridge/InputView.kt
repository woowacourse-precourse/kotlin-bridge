package bridge

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
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
        val input = readLine() ?: throw IllegalArgumentException()

        if(input != "R" && input != "Q") {
            throw IllegalArgumentException()
        }

        return input
    }
}