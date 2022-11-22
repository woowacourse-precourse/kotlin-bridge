package bridge.utils

object Print {
    fun showStartMessage() {
        println("다리 건너기 게임을 시작합니다.\n")
    }

    fun showInputBridgeLength() {
        println("다리의 길이를 입력해주세요.")
    }

    fun showInputMove() {
        println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    fun showRestart() {
        println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    }

    fun showGameResult() {
        println("\n최종 게임 결과")
    }

    fun showIsSuccess(result: String) {
        println("\n게임 성공 여부: $result")
    }

    fun showAttempt(gameCount: Int) {
        println("총 시도한 횟수: $gameCount")
    }

    fun showBridgeMap(map: String) {
        println(map)
    }

    fun showErrorMessage(error: String) {
        println(error)
    }
}