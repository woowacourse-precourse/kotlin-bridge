package util

object BridgeMessage {
    // InputView
    const val READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
    const val READ_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    const val READ_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    const val READ_BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 3이상 20이하 숫자를 입력해주세요."
    const val READ_MOVE_ERROR_MESSAGE = "[ERROR] \"U\" 나 \"D\"를 입력해주세요."
    const val READ_COMMAND_ERROR_MESSAGE = "[ERROR] \"R\" 이나 \"Q\"를 입력해주세요."
}
