package bridge

const val BRIDGE_GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
const val INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요."

const val INPUT_MOVE_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val INPUT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"


const val ERROR_NOT_NUMBER_MESSAGE = "[ERROR] 다리의 길이는 숫자로 입력해주세요."
const val ERROR_BIG_NUMBER_MESSAGE = "[ERROR] 다리의 길이가 너무 큽니다."
const val ERROR_RANGE_BRIDGE_SIZE_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."

const val ERROR_MOVE_DIRECTION_MESSAGE = "[ERROR] 이동할 칸은 U 또는 D만 가능합니다."
const val ERROR_RETRY_MESSAGE = "[ERROR] 게임 재시작 여부는 R 또는 Q만 가능합니다."