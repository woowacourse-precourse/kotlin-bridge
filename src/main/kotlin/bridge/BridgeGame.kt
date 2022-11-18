package bridge

class BridgeGame(private val bridge: List<String>) {
    var playerBridge = mutableListOf<String>()
    var resultUpBridge = mutableListOf<String>()
    var resultDownBridge = mutableListOf<String>()
    var playCount = 0

    fun move(moving: String) {
        playerBridge.add(moving)
        if (moving == "U") {
            updateUpBridge(moving)
        }
        if (moving == "D") {
            updateDownBridge(moving)
        }
    }

    private fun updateUpBridge(moving: String) {
        if (bridge[playerBridge.size -1] == moving) {
            resultUpBridge.add("O")
        }
        else {
            resultUpBridge.add("X")
        }
    }

    private fun updateDownBridge(moving: String) {
        if (bridge[playerBridge.size -1] == moving) {
            resultDownBridge.add("O")
        }
        else {
            resultDownBridge.add("X")
        }
    }

    fun retry() {
        resultUpBridge = mutableListOf()
        resultDownBridge = mutableListOf()
        playCount++

    }
    fun check(): Boolean {
        val index = playerBridge.size
        return bridge[index] == playerBridge[index]
    }

    fun over(): Boolean = bridge.size == playerBridge.size

}
