package bridge

class BridgeGame(private val bridge: List<String>) {
    var playerBridge = mutableListOf<String>()
    var resultUpBridge = mutableListOf<String>()
    var resultDownBridge = mutableListOf<String>()
    var playCount = 1

    fun move(moveState: String) {
        playerBridge.add(moveState)
        if (bridge[playerBridge.size - 1] == moveState) {
            updateBridge(moveState, RIGHT)
        }
        if (bridge[playerBridge.size - 1] != moveState) {
            updateBridge(moveState, WRONG)
        }
    }

    private fun updateBridge(moveState: String, state: String) {
        if (moveState == UP) {
            resultUpBridge.add(state)
            resultDownBridge.add(" ")
        }
        if (moveState == DOWN) {
            resultUpBridge.add(" ")
            resultDownBridge.add(state)
        }
    }

    fun retry() {
        playerBridge = mutableListOf()
        resultUpBridge = mutableListOf()
        resultDownBridge = mutableListOf()
        playCount++
    }
    fun check(): Boolean {
        val index = playerBridge.size - 1
        return bridge[index] == playerBridge[index]
    }

    fun over(): Boolean = bridge.size == playerBridge.size

    companion object {
        private const val UP = "U"
        private const val DOWN = "D"
        private const val RIGHT = "O"
        private const val WRONG = "X"
    }
}
