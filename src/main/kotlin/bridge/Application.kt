package bridge
fun makeGame(inputView: InputView, bridgeMaker: BridgeMaker): BridgeGame {
    println("다리 건너기 게임을 시작합니다.\n다리의 길이를 입력해주세요.")
    val size = inputView.readBridgeSize()
    println()
    return BridgeGame(bridgeMaker.makeBridge(size))
}
fun selectDirection(inputView: InputView, outputView: OutputView, game: BridgeGame): Boolean {
    println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    val direction = inputView.readMoving()
    val isRight = game.move(direction)
    outputView.printMap(game.route, game.bridge)
    return isRight
}
fun isRetry(inputView: InputView, game: BridgeGame): Boolean {
    println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    if (inputView.readGameCommand() == "R") {
        game.retry()
        return true
    }
    return false
}
fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val game: BridgeGame = makeGame(inputView, bridgeMaker)
    do {
        val isRight = selectDirection(inputView, outputView, game)
        if (!isRight && !isRetry(inputView, game)) break
    } while(game.route.size != game.bridge.size)
    outputView.printResult(game.route, game.bridge, game.tryNumber)
}