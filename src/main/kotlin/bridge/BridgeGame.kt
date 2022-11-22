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
        upDownBridgeOneLine = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    }

    private fun createUpDownBridge() {
        upDownBridge = listOf(
            upDownBridgeOneLine.map { it.replace("D", " ") },
            upDownBridgeOneLine.map { it.replace("U", " ") }
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
        if (restartOrQuitCommand == "Q") {
            showBridgeResult = true
            restartGame = false
        } else if (restartOrQuitCommand == "R") {
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
            oXBridge[0].add(" ")
            oXBridge[1].add("O")
            correctNum++
        } else if (upDownBridge[0][index] == " ") {
            oXBridge[0].add("X")
            oXBridge[1].add(" ")
        }
    }

    private fun checkUpDownBridgeContainU(move: String, index: Int) {
        if (move == upDownBridge[0][index]) {
            oXBridge[0].add("O")
            oXBridge[1].add(" ")
            correctNum++
        } else if (upDownBridge[1][index] == " ") {
            oXBridge[0].add(" ")
            oXBridge[1].add("X")
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
}
