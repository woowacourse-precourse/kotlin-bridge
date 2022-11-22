package bridge.constants

import bridge.data.Bridge

enum class Message(vararg message: String) {

    StartGame("다리 건너기 게임을 시작합니다."),
    InputBridgeSize("다리의 길이를 입력해주세요."),
    SelectNextFloor("이동할 칸을 선택해주세요. (위: ${Bridge.Floor.UP.command}, 아래: ${Bridge.Floor.DOWN.command})"),
    SelectRetryOrFinishGame("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    Success("성공"),
    Failure("실패"),
    FinishGame(
        "최종 게임 결과",
        "게임 성공 여부: %s",
        "총 시도한 횟수: %d",
    ),;

    private val messages: List<String> = message.toList()

    operator fun get(index: Int): String = messages[index]

    override fun toString(): String = messages.joinToString("\n")

}