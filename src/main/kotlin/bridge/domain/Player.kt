package bridge.domain

class Player(private val bridge: Bridge) {
    private var playerBridge = mutableListOf<Stage>()
    private var stage = 0

    fun updateStage(inputMoving: String): Boolean {
        val isClearStage = bridge.match(stage, inputMoving)
        stage += 1
        moveToNext(inputMoving, isClearStage)
        return isClearStage
    }

    private fun moveToNext(inputUpOrDown: String, isClearStage: Boolean) {
        when (isClearStage) {
            true -> playerBridge.add(Stage.getStageInform(inputUpOrDown, MOVE_CORRECT))
            false -> {
                playerBridge.add(Stage.getStageInform(inputUpOrDown, MOVE_FAIL))
                stage -= 1
            }
        }
    }

    fun isClear(): Boolean {
        return bridge.finishCrossBridge(stage)
    }

    fun getPlayerBridge(): List<Stage> {
        return playerBridge
    }

    fun initializePlayer() {
        stage = 0
        playerBridge = mutableListOf()
    }

    companion object {
        const val MOVE_CORRECT = "O"
        const val MOVE_FAIL = "X"
    }
}