package bridge

enum class BridgeParameter(value: Int) {
    BridgeMinLength(3),
    BridgeMaxLength(20)
}

enum class BridgeMessage(word : String){
    Start("다리 건너기 게임을 시작합니다."),
    GiveMeBridgeSize("다리의 길이를 입력해주세요."),
    WhereAreYouGo("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    End("최종 게임 결과"),
    WinorLose("게임 성공 여부: "),
    Win("승리"),
    Lose("실패"),
    HowManyTimeDidYouTry("총 시도한 횟수: "),
    AreYouWantRetry("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
}