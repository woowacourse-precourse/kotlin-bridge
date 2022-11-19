package bridge

fun main() {
    val bridge: List<String>
    val size: Int
    var moving: String
    val movingResult = mutableListOf<String>()
    var passORfail = 0
    var gameCommand = "R"
    var tryCount = 1
    /**
     * 게임 스타트
     * 길이 입력
     * +출력
     * 이동 입력
     * +출력
     * +맵 출력
     * 커맨드 입력
     * +출력
     * +재시작, 종료 출력
     * +결과 출력
     * ---------------------------------------------
     * 게임 스타트
     * 게임 진행도
     * 게임 재시작 여부
     * 게임 결과 v
     */
    ////////////////////////// 게임 스타트 ///////////////////////////////// return bridge
    println("다리 건너기 게임을 시작합니다.\n")
    size = InputView().readBridgeSize() // 다리 사이즈 입력
    println("")
    bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size) // 다리 생성
    ///////////////////////// 게임 진행도 ///////////////////////////////////
    for (route in bridge) {
        moving = InputView().readMoving() // 이동 위치 입력
        movingResult.add(BridgeGame().move(route, moving)) // 이동 결과
        passORfail = OutputView().printMap(bridge, movingResult) // 출력
        println("")
        if (passORfail == 1) break // 게임 재시작과 연결부분
    }
    ///////////////////////// 게임 재시작 여부 ///////////////////////////////
    if (passORfail == 1) { // 실패했을시
        gameCommand = InputView().readGameCommand() // 커맨드 입력
        if (gameCommand == "R") tryCount = BridgeGame().retry(tryCount, bridge)
        if (gameCommand == "Q") {
            println("최종 게임 결과")
            OutputView().printMap(bridge, movingResult)
        }
    }
    if (passORfail == 0) {
        println("최종 게임 결과")
        OutputView().printMap(bridge, movingResult)
    }
    ////////////////////////// 게임 결과 ///////////////////////////
    OutputView().printResult(gameCommand, tryCount)
}
