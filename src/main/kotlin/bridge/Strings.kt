package bridge

enum class Strings (val phrases : String){
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_BRIDGE_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ERROR_INPUT_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_INPUT_DIRECTION("[ERROR] 이동할 칸은 U 와 R 중에서 입력해야 합니다.")
}