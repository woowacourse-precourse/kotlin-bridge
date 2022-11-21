package bridge.domain

class BridgeGame(
    private val gameManager: BridgeGameManager,
    private val bridgeMaker: BridgeMaker
) {
    fun runGame() {
        gameManager.startGame()
        val bridgeSize = gameManager.getBridgeSize()
        val bridge = bridgeMaker.makeBridge(bridgeSize)

        val movement = move(bridge)
    }

    fun move(bridge: List<String>): List<String> {
        val path = mutableListOf<String>()

        for (i in bridge.indices) {
            val movement = gameManager.getMovement()
            path.add(movement)

            gameManager.printMap(path, bridge)

            if(movement != bridge[i]) { break }
        }

        return path
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
