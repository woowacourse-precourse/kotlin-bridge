package bridge

fun main() {
    val bridge : List<String>

    println("다리 건너기 게임을 시작합니다.")
    println("다리의 길이를 입력해주세요.")
    bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(InputView().readBridgeSize())
    println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    InputView().readMoving()
    // printmap

}
