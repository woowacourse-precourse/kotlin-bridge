package bridge

class Message {
    companion object {

        const val BRIDGE_SIZE_IS_NOT_INTEGER = "[ERROR] 입력한 다리 길이는 정수가 아닙니다."
        const val BRIDGE_SIZE_IS_NOT_AVAILABLE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."

        const val BRIDGE_MOVE_IS_NOT_U_OR_D = "[ERROR] 입력한 값은 'U' 또는 'D'가 아닙니다."

        const val GAME_COMMAND_IS_NOT_R_OR_Q = "[ERROR] 입력한 값은 'R' 또는 'Q'가 아닙니다."

        const val START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다."

        const val PRINT_BRIDGE_SIZE = "다리의 길이를 입력해주세요."

        const val PRINT_BRIDGE_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"

        const val PRINT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

        const val PRINT_GAME_RESULT = "최종 게임 결과"

        const val PRINT_IS_SUCCESS = "게임 성공 여부"

        const val PRINT_SUCCESS = "성공"
        const val PRINT_FAILED = "실패"

        const val PRINT_TRY_COUNT = "총 시도한 횟수"
    }
}