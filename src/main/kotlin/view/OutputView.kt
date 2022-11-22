package view

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    private val MESSAGE_START = "다리 건너기 게임을 시작합니다.\n"
    private val MESSAGE_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
    private val MESSAGE_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    private val MESSAGE_SUCCESS_OR_FAILURE = "게임 성공 여부:"
    private val MESSAGE_TOTAL_TRY = "총 시도한 횟수:"
    private val MESSAGE_READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    private val MESSAGE_FRONT_BRACKET = "["
    private val MESSAGE_BACK_BRACKET = "]"
    private val MESSAGE_RESULT_MAP = "최종 게임 결과"

    private val inputView = InputView()

    fun printStart(): String {
        return MESSAGE_START
    }

    fun printBridgeSize(): String {
        return MESSAGE_BRIDGE_SIZE
    }

    fun printMoving(): String {
        println(MESSAGE_READ_MOVING)
        val move = inputView.readMoving()
        println(move)
        return move
    }

    fun printRetry(): String {
        println(MESSAGE_RETRY)
        return inputView.readGameCommand()
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeMap: Pair<List<String>, List<String>>) {
        println("$MESSAGE_FRONT_BRACKET ${bridgeMap.first.joinToString(" ")} $MESSAGE_BACK_BRACKET")
        println("$MESSAGE_FRONT_BRACKET ${bridgeMap.second.joinToString(" ")} $MESSAGE_BACK_BRACKET\n")
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(successOrFailure: String, totalTry: Int) {
        println("$MESSAGE_SUCCESS_OR_FAILURE $successOrFailure")
        println("$MESSAGE_TOTAL_TRY $totalTry")
    }

    fun printResultMap(){
        println(MESSAGE_RESULT_MAP)
    }
}
