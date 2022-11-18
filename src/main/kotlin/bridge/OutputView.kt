package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
class OutputView {
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




    companion object {
        private const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
        private const val REQUEST_INPUT_MESSAGE = "다리의 길이를 입력해주세요."
        private const val UP_OR_DOWN_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        private const val ERROR = "[ERROR] "
        private const val WRONG_SIZE_INPUT_MESSAGE = "다리의 길이는 숫자만 입력 가능합니다."
        private const val WRONG_SIZE_Range_MESSAGE = "다리의 길이는 3과 20 사이의 숫자만 가능합니다."
        private const val WRONG_MOVING_INPUT_MESSAGE = "움직이는 명령어는 U:위, D:아래 만 입력 가능합니다."

        fun printStart() = println(GAME_START_MESSAGE + "\n\n" + REQUEST_INPUT_MESSAGE)
        fun printUpOrDown() = println("\n" + UP_OR_DOWN_MESSAGE)
        fun printSizeInputError() = println(ERROR + WRONG_SIZE_INPUT_MESSAGE)
        fun printSizeRangeError() = println(ERROR + WRONG_SIZE_Range_MESSAGE)
        fun printMovingInputError() = println(ERROR + WRONG_MOVING_INPUT_MESSAGE)

    }
}
