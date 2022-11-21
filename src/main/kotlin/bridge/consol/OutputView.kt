package bridge.consol

const val ERROR_MESSAGE = "[ERROR]"
const val NOT_NUMBER_ERROR = "숫자 이여야 합니다."
class OutputView {
    fun printStartGame() {
        println(Message.START_GAME_MESSAGE)
    }

    fun printInputLength() {
        println(Message.INPUT_LENGTH_MESSAGE)
    }

    fun printInputMove() {
        println(Message.INPUT_MOVE_MESSAGE)
    }

    fun printInputGameCommand() {
        println(Message.INPUT_COMMAND_MESSAGE)
    }

    fun printResultGuide() {
        println(Message.RESULT_GUIDE_MESSAGE)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(map: Pair<String, String>) {
        println("[${map.first}]")
        println("[${map.second}]")
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(gameResult: Pair<String, Int>) {
        println(Message.WHETHER_SUCCESSFUL_MESSAGE + gameResult.first)
        println(Message.NUMBER_OF_ATTEMPT_MESSAGE + gameResult.second.toString())
    }
}
