package bridge.io


import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView(private val validChecker: ValidChecker = ValidChecker()) {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        val size: Int
        try {
            size = Console.readLine().toInt()
            validChecker.checkBridgeSize(size)
        } catch (e: IllegalArgumentException) {
            println("[ERROR]")
            return readBridgeSize()
        }
        return size
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val choice: String
        try {
            choice = Console.readLine()
            validChecker.checkUorD(choice)
        } catch (e: IllegalArgumentException) {
            println("[ERROR]")
            return readMoving()
        }
        return choice
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): Boolean {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val retry: Boolean
        try {
            val coin = Console.readLine()
            retry = validChecker.checkRorQ(coin)
        } catch (e: IllegalArgumentException) {
            println("[ERROR]")
            return readGameCommand()
        }
        return retry
    }
}
