package values

enum class Request(val message: String) {
    MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    BRIDGE_SIZE("다리의 길이를 입력해주세요.")
}