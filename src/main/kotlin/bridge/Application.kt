package bridge

val input = InputView()
val output = OutputView()
val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

fun main() {
    println("다리 건너기 게임을 시작합니다.")
    val size = input.readBridgeSize()
    val bridge = bridgeMaker.makeBridge(size)
    val game = BridgeGame(bridge)
    playGames(size, game)
}

/**
 * @param bridge 이어진 다리의 정보
 * @param game 브릿지 게임
 * @return 브릿지 게임 플레이 결과
 */
fun playGame(size: Int, game: BridgeGame): Boolean {
    var isGameOver = false
    var index = 0
    while(index != size && !isGameOver) {
        var moving = input.readMoving()
        isGameOver = !game.move(index++, moving)
        output.printMap(game)
    }
    return !isGameOver
}

/**
 * @brief 브릿지 게임을 여러 번 플레이한다
 * @param bridge 이어진 다리의 정보
 * @param game 브릿지 게임
 */
fun playGames(size: Int, game: BridgeGame) {
    var success: Boolean
    var tries = 0
    do {
        game.retry()
        success = playGame(size, game)
        tries += 1
    } while (!success && input.readGameCommand() == "R")
    output.printResult(success, tries, game)
}