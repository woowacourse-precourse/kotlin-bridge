package bridge

fun main() {

    val inputView = InputView()
    val outputView = OutputView()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val game: BridgeGame = gameStart(inputView, bridgeMaker)

    while (!game.quit()) {
        val moveCheck = selectDirection(inputView, outputView, game)

        if (!moveCheck && !retry(inputView, game)) {
            break
        }
    }

    outputView.printResult(game.route, game.bridge, game.tryNum)
}

fun gameStart(inputView: InputView, bridgeMaker: BridgeMaker): BridgeGame {
    println("다리 건너기 게임을 시작합니다.")
    println("다리의 길이를 입력해주세요.")

    val bridgeSize = inputView.readBridgeSize()
    println()
    return BridgeGame(bridgeMaker.makeBridge(bridgeSize))
}


fun selectDirection(inputView: InputView, outputView: OutputView, game: BridgeGame): Boolean {
    println("이동할 칸을 선택해주세요. (위: U, 아래: D)")

    val direction = inputView.readMoving()
    val moveCheck = game.move(direction)

    outputView.printMap(game.route, game.bridge)
    return moveCheck
}

fun retry(inputView: InputView, game: BridgeGame): Boolean {
    println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    val retry = inputView.readGameCommand()
    println(retry)

    if (retry == "R") {
        game.retry()
        return true
    }
    return false
}