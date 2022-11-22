package bridge

import camp.nextstep.edu.missionutils.Console
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     * @return 다리의 길이 반환. 예외일 경우 다시 받는 과정
     */
    fun readBridgeSize(): Int {
        println(Message.INPUT_BRIDGE_SIZE.message)
        return try {
            val sizeString = Console.readLine()
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
            require(size in Bridge.LESS_BRIDGE_SIZE.params .. Bridge.MOST_BRIDGE_SIZE.params)
            return size
        }catch (e: IllegalArgumentException){
            println(Message.BRIDGE_SIZE_RANGE_ERROR.message)
            throw e
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     * @return: 사용자가 이동할 칸 반환. 예외 시 입력 받는 과정으로 돌아감.
     */
    fun readMoving(): String {
        println(Message.INPUT_BRIDGE_MOVE.message)
        return try {
            val move = Console.readLine()
            checkMove(move)
            move
        }catch (e: IllegalArgumentException){
            readMoving()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력 예외 처리: 입력값이 "U", "D" 가 아닐 경우
     * @param: User 입력값
     * 예외시, ERROR 메시지 반환
     */
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
     * @return: 사용자가 게임을 다시 시도할지 종료할지 여부 반환. 예외시 다시 입력 받는 과정으로 돌아감.
     */
    fun readGameCommand(): String {
        println(Message.INPUT_GAME_COMMAND.message)
        return try {
            val gameCommand = Console.readLine()
            checkGameCommand(gameCommand)
            gameCommand
        }catch (e: IllegalArgumentException){
            readGameCommand()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부 입력 예외 처리: 입력값이 "R", "E" 가 아닐 경우
     * @param: User 입력값
     * 예외시, ERROR 메시지 반환
     */
    private fun checkGameCommand(gameCommand:String){
        try {
            require(gameCommand == GameCommand.Retry.params || gameCommand == GameCommand.Exit.params)
        } catch (e: IllegalArgumentException){
            println(Message.GAME_COMMAND_ERROR.message)
            throw e
        }
    }

    enum class Message(
            val message: String
    ) {
        INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
        BRIDGE_SIZE_INT_ERROR("[ERROR]: 다리의 길이는 숫자 형식이어야 합니다."),
        BRIDGE_SIZE_RANGE_ERROR("[ERROR]: 다리의 길이는 3이상 20 이하의 값을 가져야합니다."),
        INPUT_BRIDGE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        BRIDGE_MOVE_ERROR("[ERROR]: 이동할 칸 입력값은 U, D 둘 중 하나여야 합니다."),
        INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
        GAME_COMMAND_ERROR("[ERROR]: 재시도 여부 입력값은 R, Q 둘 중 하나여야 합니다."),
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
    enum class GameCommand(
            val params:String
    ){
        Retry("R"),
        Exit("Q")
    }
}
