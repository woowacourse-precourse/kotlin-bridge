package bridge

class BridgeGame(private val bridgeLength: Int) {

    private lateinit var upDownBridge: List<List<String>>
    private lateinit var upDownBridgeOneLine: List<String>
    private lateinit var oXBridge: List<MutableList<String>>
    private var totalAttempts = 0
    private var correctNum = 0
    private var restartGame = true
    private var showBridgeResult = false

    init {
        createUpDownBridgeOneLine()
        createUpDownBridge()
    }

    private fun createUpDownBridgeOneLine() {
        upDownBridgeOneLine = BridgeMaker(BridgeRandomNumberGenerator()).makeUpDownBridge(bridgeLength)
    }

    private fun createUpDownBridge() {
        upDownBridge = listOf(
            upDownBridgeOneLine.map { it.replace(DOWN, BLANK) },
            upDownBridgeOneLine.map { it.replace(UP, BLANK) }
        )
    }

    fun initStartGame() {
        oXBridge = mutableListOf(
            mutableListOf(),
            mutableListOf()
        )
        correctNum = 0
        totalAttempts++
    }

    fun retry(restartOrQuitCommand: String): Boolean {
        showBridgeResult = false
        if (restartOrQuitCommand == QUIT) {
            showBridgeResult = true
            restartGame = false
        } else if (restartOrQuitCommand == RESTART) {
            restartGame = true
        }
        return true
    }

    fun move(move: String, index: Int) {
        checkUpDownBridgeContainU(move, index)
        checkUpDownBridgeContainD(move, index)
    }

    private fun checkUpDownBridgeContainD(move: String, index: Int) {
        if (move == upDownBridge[1][index]) {
            oXBridge[0].add(BLANK)
            oXBridge[1].add(CORRECT)
            correctNum++
        } else if (upDownBridge[0][index] == BLANK) {
            oXBridge[0].add(WRONG)
            oXBridge[1].add(BLANK)
        }
    }

    private fun checkUpDownBridgeContainU(move: String, index: Int) {
        if (move == upDownBridge[0][index]) {
            oXBridge[0].add(CORRECT)
            oXBridge[1].add(BLANK)
            correctNum++
        } else if (upDownBridge[1][index] == BLANK) {
            oXBridge[0].add(BLANK)
            oXBridge[1].add(WRONG)
        }
    }

    fun getRestartGame() = restartGame
    fun getShowBridgeResult() = showBridgeResult
    fun getOXBridge() = oXBridge
    fun getTotalAttempts() = totalAttempts
    fun getCorrectNum() = correctNum
    fun setRestartGame(restart: Boolean) {
        restartGame = restart
    }

    companion object {
        const val UP = "U"
        const val DOWN = "D"
        const val BLANK = " "
        const val QUIT = "Q"
        const val RESTART = "R"
        const val CORRECT = "O"
        const val WRONG = "X"
    }
}
