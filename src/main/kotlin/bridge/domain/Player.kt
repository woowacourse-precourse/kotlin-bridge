package bridge.domain

class Player(private val bridge: Bridge) {
    private var playerBridge = mutableListOf<Stage>()
    private var upBridge = mutableListOf<String>()
    private var downBridge = mutableListOf<String>()
    private var stage = 0

    fun updateStage(inputMoving: String): Boolean {
        val isClearStage = bridge.match(stage, inputMoving)
        stage += 1
        moveToNext(inputMoving, isClearStage)
        return isClearStage
    }

    private fun moveToNext(inputUpOrDown: String, isClearStage: Boolean) {
        when (isClearStage) {
            true -> updateBridge(inputUpOrDown, MOVE_CORRECT)
            false -> {
                updateBridge(inputUpOrDown, MOVE_FAIL)
                stage -= 1
            }
        }
    }

    private fun updateBridge(inputUpOrDown: String, stageResult: String) {
        when (inputUpOrDown) {
            MOVE_UP -> updateUpBridge(stageResult)
            MOVE_DOWN -> updateDownBridge(stageResult)
        }
    }

    private fun updateUpBridge(stageResult: String) {
        upBridge.add(stageResult)
        downBridge.add(NOT_MOVE_TO_HERE)
    }

    private fun updateDownBridge(stageResult: String) {
        upBridge.add(NOT_MOVE_TO_HERE)
        downBridge.add(stageResult)
    }

    fun isClear(): Boolean {
        return bridge.finishCrossBridge(stage)
    }

    fun getPlayerBridge(): List<Stage> {
        return playerBridge
    }

    fun getUpBridge(): List<String> {
        return upBridge
    }

    fun getDownBridge(): List<String> {
        return downBridge
    }

    fun initializePlayer() {
        stage = 0
        upBridge = mutableListOf<String>()
        downBridge = mutableListOf<String>()
    }

    companion object {
        const val MOVE_UP = "U"
        const val MOVE_DOWN = "D"
        const val MOVE_CORRECT = "O"
        const val MOVE_FAIL = "X"
        const val NOT_MOVE_TO_HERE = " "
    }
}