package bridge.domain

class Player {
    private var playerBridge = mutableListOf<String>()

    fun updateStage(inputMoving: String) {
        playerBridge.add(inputMoving)
    }

    fun isClear(bridge: List<String>): Boolean {
        return playerBridge.size == bridge.size
    }
}