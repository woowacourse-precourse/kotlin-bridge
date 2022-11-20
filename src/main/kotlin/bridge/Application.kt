package bridge

fun main() {
    val player = getPlayer()
    player.startGame()
}


private fun getPlayer() = Player(
    getGameView(),
    getBridgeGame()
)

private fun getGameView() = GameView(
    InputView(),
    OutputView()
)
private fun getBridgeGame() =
    BridgeGame(
        BridgeMaker(
            BridgeRandomNumberGenerator()
        )
    )
