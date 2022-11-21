package bridge

val input = InputView()
val output = OutputView()
val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

fun main() {
    // TODO: 프로그램 구현
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