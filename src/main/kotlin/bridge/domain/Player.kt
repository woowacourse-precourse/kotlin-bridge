package bridge.domain

class Player(private val bridge: Bridge) {
    private var upBridge = mutableListOf<String>()
    private var downBridge = mutableListOf<String>()
    private var stage = 0

    fun updateStage(inputMoving: String): Boolean {
        val isClearStage = bridge.match(stage, inputMoving)
        when (isClearStage) {
            true -> updateBridge(inputMoving, MOVE_CORRECT)
            false -> updateBridge(inputMoving, MOVE_FAIL)
        }
        stage += 1
        return isClearStage
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
        return bridge.finishCrossBridge(upBridge.size)
    }

    companion object {
        const val MOVE_UP = "U"
        const val MOVE_DOWN = "D"
        const val MOVE_CORRECT = "O"
        const val MOVE_FAIL = "X"
        const val NOT_MOVE_TO_HERE = " "
    }
}