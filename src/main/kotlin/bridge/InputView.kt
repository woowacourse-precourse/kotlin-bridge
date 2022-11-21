package bridge

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {

    fun inputUser(): String {
        val userInputNumber = camp.nextstep.edu.missionutils.Console.readLine()
        userInputNumber ?: println("[Error]")
        if (userInputNumber!!.isEmpty()){
            throw IllegalArgumentException()
        }
        return userInputNumber
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val userInputNumber =inputUser()
        try {
            bridge.util.InputVaildator().checkNullBridgeSize(userInputNumber)
            bridge.util.InputVaildator().checkNullBridgeSize(userInputNumber)
        }catch (e:java.lang.IllegalArgumentException) {
            println("[ERROR]")
            return readBridgeSize()
        }
        return userInputNumber.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val userInputNumber = inputUser()
        try {
            bridge.util.InputVaildator().checkNullBridgeString(userInputNumber)
            bridge.util.InputVaildator().checkSelectBridgePatten(userInputNumber)
        }catch (e:IllegalArgumentException){
            println("[ERROR]")
            return readMoving()
        }
        return userInputNumber
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
