package bridge

class BridgeGame(private val bridge: List<String>) {
    var playerBridge = mutableListOf<String>()
    var resultUpBridge = mutableListOf<String>()
    var resultDownBridge = mutableListOf<String>()
    var playCount = 0

    fun move(moving: String) {
        playerBridge.add(moving)
        if (bridge[playerBridge.size - 1] == moving) {
            updateRightBridge(moving)
        }
        if (bridge[playerBridge.size - 1] != moving) {
            updateWrongBridge(moving)
        }
    }

    private fun updateRightBridge(moving: String) {
        if (moving == "U") {
            resultUpBridge.add("O")
            resultDownBridge.add(" ")
        }
        if (moving == "D") {
            resultUpBridge.add(" ")
            resultDownBridge.add("O")
        }
    }

    private fun updateWrongBridge(moving: String) {
        if (moving == "U") {
            resultUpBridge.add("X")
            resultDownBridge.add(" ")
        }
        if (moving == "D") {
            resultUpBridge.add(" ")
            resultDownBridge.add("X")
        }
    }

    fun retry() {
        resultUpBridge = mutableListOf()
        resultDownBridge = mutableListOf()
        playCount++

    }
    fun check(): Boolean {
        val index = playerBridge.size - 1
        return bridge[index] == playerBridge[index]
    }

    fun over(): Boolean = bridge.size == playerBridge.size
}
