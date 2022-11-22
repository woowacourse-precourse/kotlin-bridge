package bridge.utils


// Input Text
const val BRIDGE_GAME_START = "다리 건너기 게임을 시작합니다."
const val CHOOSE_BRIDGE_LENGTH = "다리의 길이를 입력해주세요."
const val CHOOSE_BRIDGE_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val CHOOSE_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

// Output Text
const val SUCCESS_TEXT = "성공"
const val FAIL_TEXT = "실패"
const val FINAL_GAME_RESULT = "최종 게임 결과"
const val GAME_IS_SUCCESS = "게임 성공 여부: "
const val TOTAL_TRY_COUNT_TEXT = "총 시도한 횟수: "

// Error Text
const val ERROR = "[ERROR]"
const val ERR_GAME_NOT_ENDED = ERROR.plus("게임이 끝나지 않았습니다.")
const val ERR_BRIDGE_LENGTH = ERROR.plus("다리의 길이는 3이상 20이하 숫자 입니다.")
const val ERR_BRIDGE_SYMBOL = ERROR.plus("U 또는 D로 입력해야 합니다.")
const val ERR_RETRY_SYMBOL = ERROR.plus("R 또는 Q를 입력해야 합니다.")
