package exception

class GameOver(private val isRetry: String) {
    init {
        check(isRetry == "R" || isRetry == "Q") {
            print("[ERROR] 게임을 재시작 및 종료할 수 없습니다. R(재시작)이나 Q(종료)를 입력해주세요.")
        }
    }
}