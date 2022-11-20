package view

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    private val MESSAGE_START = "다리 건너기 게임을 시작합니다.\n"
    private val MESSAGE_BRIDGE_SIZE = "다리의 길이를 입력해주세요."

    fun printStart():String{
        return MESSAGE_START
    }

    fun printBridgeSize():String{
        return MESSAGE_BRIDGE_SIZE
    }

    fun printMoving(): String{
        val move = InputView().readMoving()
        println("$move\n")
        return move
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {}

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
