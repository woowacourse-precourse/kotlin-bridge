package bridge.domain

class Player(private val bridge: Bridge) {
    private var playerBridge = mutableListOf<String>()
    private var stage = 0

    fun updateStage(inputMoving: String): Boolean {
        val isClearStage = bridge.match(stage, inputMoving)
        when(isClearStage) {
            true -> playerBridge.add(inputMoving)
            false -> playerBridge.add(failToClearStage(inputMoving))
        }
        stage += 1
        return isClearStage
    }

    fun isClear(): Boolean {
        return bridge.finishCrossBridge(playerBridge.size)
    }

    private fun failToClearStage(inputUpOrDown: String): String {
        return inputUpOrDown + FAIL_TO_STAGE_CLEAR
    }

    companion object {
        const val FAIL_TO_STAGE_CLEAR = "F"
    }
}