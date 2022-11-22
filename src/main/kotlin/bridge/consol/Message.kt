package bridge.consol

object Message {
    const val START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다. \n"
    const val INPUT_LENGTH_MESSAGE = "다리의 길이를 입력해주세요."
    const val INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    const val INPUT_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    const val RESULT_GUIDE_MESSAGE = "최종 게임 결과"
    const val WHETHER_SUCCESSFUL_MESSAGE = "게임 성공 여부: "
    const val NUMBER_OF_ATTEMPT_MESSAGE = "총 시도한 횟수: "
    const val NOT_QUIT_OR_RETRY = "Q 또는 R 를 눌러 주세요"
    const val NOT_UP_OR_DOWN = "U 또는 D 를 눌러 주세요"
    const val NOT_INCLUSIVE_RANGE = "3 ~ 20 사이의 숫자를 입력해 주세요"
    const val UP = "U"
    const val DOWN = "D"
    const val QUIT = "Q"
    const val RETRY = "R"
    const val RIGHT = "O"
    const val WRONG = "X"
    const val BLANK = "   "
    const val PARTITION = "|"
}