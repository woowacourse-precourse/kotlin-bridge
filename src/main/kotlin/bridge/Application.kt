package bridge

fun main() {
    val bridge: List<String>
    val size: Int
    var moving: String
    val movingResult = mutableListOf<String>()
    var passORfail = 0
    var gameCommand = "R"
    var tryCount = 1

    println("다리 건너기 게임을 시작합니다.")
    println("")
    println("다리의 길이를 입력해주세요.")
    size = InputView().readBridgeSize() // 다리 사이즈 입력
    println("")
    bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size) // 다리 생성
    for (route in bridge) {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        moving = InputView().readMoving() // 이동 위치 입력
        movingResult.add(BridgeGame().move(route, moving)) // 이동 결과
        passORfail = OutputView().printMap(bridge, movingResult) // 출력
        println("")
        if (passORfail == 1) break
    }
    if (passORfail == 1) { // 실패했을시
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    }
    if (passORfail == 0) { // 성공했을시
        println("최종 게임 결과")
        OutputView().printMap(bridge, movingResult)
    }
    OutputView().printResult(gameCommand, tryCount)
}
