package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printBridge() = println(PRINT_BRIDGE_LENGTH)

    fun printMove() = println(PRINT_MOVING_COMMAND)

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(triple: Triple<Int, MutableList<String>, MutableList<String>>) {
        val (position, upBridge, downBridge) = triple
        println("[ ${upBridge.slice(0..position).joinToString(SEP)} ]")
        println("[ ${downBridge.slice(0..position).joinToString(SEP)} ]")
    }

    fun printRetry() = println(PRINT_RETRY_COMMAND)

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(triple: Triple<Int, MutableList<String>, MutableList<String>>, isSuccess: Boolean) {
        println(PRINT_RESULT)
        this.printMap(triple)
        when (isSuccess) {
            true -> println(PRINT_RESULT_SUCCESS)
            false -> println(PRINT_RESULT_FAIL)
        }
    }

    fun printTryNumber(tryCounter: Int) = println("$PRINT_TOTAL_TRIED $tryCounter")

    companion object {
        const val PRINT_START = "다리 건너기 게임을 시작합니다."
        const val PRINT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요."
        const val PRINT_MOVING_COMMAND = "이동할 칸을 선택해주세요. (위: ${InputView.COMMAND_UP}, 아래: ${InputView.COMMAND_DOWN})"
        const val PRINT_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: ${InputView.COMMAND_RESTART}, 종료: ${InputView.COMMAND_QUIT})"
        const val PRINT_RESULT = "최종 게임 결과"
        const val PRINT_RESULT_SUCCESS = "게임 성공 여부: 성공"
        const val PRINT_RESULT_FAIL = "게임 성공 여부: 실패"
        const val PRINT_TOTAL_TRIED = "총 시도한 횟수:"
        const val SEP = " | "
    }
}
