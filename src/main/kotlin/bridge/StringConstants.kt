package bridge

//Error
const val ERROR = "[ERROR]"
const val ERROR_LENGTH = ERROR.plus("3이상 20이하 숫자만 입력해주세요.")
const val ERROR_MOVE = ERROR.plus("'U'(위) 혹은 'D'(아래) 값만 입력 가능합니다.")
const val ERROR_RESTART = ERROR.plus("'R'(재시도) 혹은 'Q'(종료) 값만 입력 가능합니다.")

//Input
const val BRIDGE_START = "다리 건너기 게임을 시작합니다."
const val BRIDGE_LENGTH = "다리의 길이를 입력해주세요."
const val BRIDGE_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val BRIDGE_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

//Output
const val GAME_RESULT = "최종 게임 결과"
const val GAME_SUCCESS = "게임 성공 여부: 성공"
const val GAME_FAIL = "게임 성공 여부: 실패"
const val GAME_COUNT = "총 시도한 횟수: "

//Output-Bridge
const val POINT_PASS = " O "
const val POINT_WRONG = " X "
const val POINT_EMPTY = "   "
const val POINT_START = "["
const val POINT_MIDDLE = "|"
const val POINT_END = "]"
