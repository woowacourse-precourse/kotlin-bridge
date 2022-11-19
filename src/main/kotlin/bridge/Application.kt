package bridge

fun main() {
    val inputView = InputView()

    println("다리 건너기 게임을 시작합니다.\n")
    println("다리의 길이를 입력해주세요.")
    inputView.readBridgeSize()
    println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    inputView.readMoving()
    println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    inputView.readGameCommand()
}
