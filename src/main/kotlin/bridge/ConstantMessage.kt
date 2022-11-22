package bridge

object ConstantMessage {
    const val START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.\n"
    const val INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
    const val INPUT_SELECT_MOVE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)"
    const val INPUT_GAME_COMMAND = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    const val BRIDGE_GAME_RESULT = "\n최종 게임 결과"
    const val BRIDGE_GAME_SUCCESS = "\n게임 성공 여부: 성공"
    const val BRIDGE_GAME_UNSUCCESS = "\n게임 성공 여부: 실패"
    const val TOTAL_TRY_COUNT = "총 시도한 횟수: "
    //EXCEPTION
    const val INPUT_MORE_RANGE_EXCEPTION = "[ERROR] 다리의 길이는 3보다 커야합니다."
    const val INPUT_LESS_RANGE_EXCEPTION = "[ERROR] 다리의 길이는 20보다 작아야합니다."
    const val INPUT_TYPE_EXCEPTION = "[ERROR] 다리의 길이는 숫자만 입력 가능합니다."
    const val INPUT_MOVE_EXCEPTION = "[ERROR] 이동할 칸은 U와 D만 입력 가능합니다."
    const val INPUT_GAME_COMMAND_EXCEPTION = "[ERROR] 게임을 다시 시도할지 여부는 Q와 R만 입력 가능합니다."
}