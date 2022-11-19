package bridge

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(MESSAGE.INPUTBRIDGESIZE.message)
        return try {
            val sizeString = camp.nextstep.edu.missionutils.Console.readLine()
            checkBridgeSizeInt(sizeString)
            checkBridgeSizeRange(sizeString.toInt())
        } catch (e: IllegalArgumentException){
            -1
        }
    }
    /**
     * 다리의 길이 입력값 예외 처리: 입력값이 정수형이 아닐 경우
     */
    private fun checkBridgeSizeInt(sizeString:String){
        try {
            sizeString.toInt()
        }catch (e: IllegalArgumentException){
            println(MESSAGE.BRIDGESIZEINTERROR.message)
            throw e
        }
    }
    /**
     * 다리의 길이 입력값 예외 처리: 입력값이 3 - 20 사이 값이 아닐 경우
     */
    private fun checkBridgeSizeRange(size:Int): Int {
        try {
            require(size in 3 .. 20)
            return size
        }catch (e: IllegalArgumentException){
            println(MESSAGE.BRIDGESIZERANGEERROR.message)
            throw e
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    enum class MESSAGE(
            val message: String
    ) {
        INPUTBRIDGESIZE("다리의 길이를 입력해주세요."),
        BRIDGESIZEINTERROR("[ERROR]: 다리의 길이는 숫자 형식이어야 합니다."),
        BRIDGESIZERANGEERROR("[ERROR]: 다리의 길이는 3이상 20 이하의 값을 가져야합니다.")
    }
}
