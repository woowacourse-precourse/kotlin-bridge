package bridge

enum class BridgeParameter(value: Int) {
    BridgeMinLength(3),
    BridgeMaxLength(20)
}

enum class BridgeMessage(word : String){
    Start("다리 건너기 게임을 시작합니다."),
    End("최종 게임 결과"),
    WinorLose("게임 성공 여부: "),
    Win("승리"),
    Lose("실패"),
    AreYouWantRetry("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
}