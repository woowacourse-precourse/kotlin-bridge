package bridge

class OutputView {
    fun printGameStart() {
        println("다리 건너기 게임을 시작합니다.\n")
    }

    fun printBridgeLength() {
        println("다리의 길이를 입력해주세요.")
    }

    fun printSelectBlock() {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    fun printRestart() = println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")

    fun printMap() {}

    fun printResult() {}
}
