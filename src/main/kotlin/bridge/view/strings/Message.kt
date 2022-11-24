package bridge.view.strings

import bridge.domain.game.Bridge

enum class Message(private val message: String) {

    StartGame("다리 건너기 게임을 시작합니다.\n"),
    InputBridgeSize("다리의 길이를 입력해주세요."),
    SelectNextFloor("이동할 칸을 선택해주세요. (위: ${Bridge.Floor.Up.value}, 아래: ${Bridge.Floor.Down.value})"),
    SelectRetryOrFinishGame("게임을 다시 시도할지 여부를 입력해주세요. (재시도: ${Command.Power.Retry}, 종료: ${Command.Power.Quit})"),
    Success("성공"),
    Failure("실패"),
    FinishGame("""
        최종 게임 결과
        %s
        게임 성공 여부: %s
        총 시도한 횟수: %d
    """.trimIndent()),;

    override fun toString(): String = message

}