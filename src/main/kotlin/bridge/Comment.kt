package bridge

class Comment {
    //게임 안내 멘트
    enum class GameComment(val message: String) {
        START("다리 건너기 게임을 시작합니다.\n"),
        WIN("게임 성공 여부: "),
        RESULT("최종 게임 결과"),
        COUNT("총 시도한 횟수: ");
    }
    //입력 요구 멘트
    enum class InputComment(val message: String) {
        RANGE("다리의 길이를 입력해주세요."),
        CHOICE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        OVER("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}




