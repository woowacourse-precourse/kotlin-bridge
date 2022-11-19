package bridge

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     * @return 다리의 길이 반환. 예외일 경우 -1 반환
     */
    fun readBridgeSize(): Int {
        println(Message.INPUT_BRIDGE_SIZE.message)
        return try {
            val sizeString = camp.nextstep.edu.missionutils.Console.readLine()
            checkBridgeSizeInt(sizeString)
            checkBridgeSizeRange(sizeString.toInt())
        } catch (e: IllegalArgumentException){
            readBridgeSize()
        }
    }
    /**
     * 다리의 길이 입력값 예외 처리: 입력값이 정수형이 아닐 경우
     * @param: User 입력값
     * @return: Int 형을 보장 받은 입력값
     */
    private fun checkBridgeSizeInt(sizeString:String){
        try {
            sizeString.toInt()
        }catch (e: IllegalArgumentException){
            println(Message.BRIDGE_SIZE_INT_ERROR.message)
            throw e
        }
    }
    /**
     * 다리의 길이 입력값 예외 처리: 입력값이 3 - 20 사이 값이 아닐 경우
     * @param: Int 형을 보장 받은 입력값
     * @return: 예외가 없는 다리의 길이
     */
    private fun checkBridgeSizeRange(size:Int): Int {
        try {
            // TODO: 3, 20 상수처리
            require(size in Bridge.LESS_BRIDGE_SIZE.params .. Bridge.MOST_BRIDGE_SIZE.params)
            return size
        }catch (e: IllegalArgumentException){
            println(Message.BRIDGE_SIZE_RANGE_ERROR.message)
            throw e
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(Message.INPUT_BRIDGE_MOVE.message)
        return try {
            val move = camp.nextstep.edu.missionutils.Console.readLine()
            checkMove(move)
            move
        }catch (e: IllegalArgumentException){
            readMoving()
        }
    }
    private fun checkMove(move:String){
        try {
            require(move == Move.Up.params || move == Move.Down.params)
        } catch (e: IllegalArgumentException){
            println(Message.BRIDGE_MOVE_ERROR.message)
            throw e
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    enum class Message(
            val message: String
    ) {
        INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
        BRIDGE_SIZE_INT_ERROR("[ERROR]: 다리의 길이는 숫자 형식이어야 합니다."),
        BRIDGE_SIZE_RANGE_ERROR("[ERROR]: 다리의 길이는 3이상 20 이하의 값을 가져야합니다."),
        INPUT_BRIDGE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        BRIDGE_MOVE_ERROR("[ERROR]: 이동할 칸 입력값은 U, D 둘 중 하나여야 합니다.")
    }
    enum class Bridge(
            val params:Int
    ){
        LESS_BRIDGE_SIZE(3),
        MOST_BRIDGE_SIZE(20)
    }
    enum class Move(
            val params:String
    ){
        Up("U"),
        Down("D")
    }
}
