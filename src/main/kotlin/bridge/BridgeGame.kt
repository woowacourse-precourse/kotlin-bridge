package bridge

class BridgeGame(private val bridgeLength: Int) {

    private lateinit var bridge: List<List<String>>
    private lateinit var bridgeLine: List<String>
    private lateinit var oxBridge: List<MutableList<String>>
    private var totalAttempts = 0
    private var correctDirection = 0
    private var restartGame = true
    private var showResult = false

    init {
        createBridgeLine()
        createBridge()
    }

    private fun createBridge() {
        bridge = listOf(
            bridgeLine.map { it.replace("D", " ") },
            bridgeLine.map { it.replace("U", " ") }
        )
    }

    private fun createBridgeLine() {
        bridgeLine = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    }

    fun retry(restartCommand: String): Boolean {
        showResult = false
        if (restartCommand == "Q") {
            showResult = true
            restartGame = false
        } else if (restartCommand == "R") {
            restartGame = true
        }
        return true
    }

    fun getRestart() = restartGame

    fun setRestart(restart: Boolean) {
        restartGame = restart
    }

    fun getShowResult() = showResult

    fun getOXBridge() = oxBridge

    fun getTotalAttempts() = totalAttempts

    fun getCorrectDirection() = correctDirection

    fun initStartGame() {
        oxBridge = mutableListOf(
            mutableListOf(),
            mutableListOf()
        )
        correctDirection = 0
        totalAttempts++
    }

    private fun checkD(move: String, index: Int) {
        if (move == bridge[1][index]) {
            oxBridge[0].add(" ")
            oxBridge[1].add("O")
            correctDirection++
        } else if (bridge[0][index] == " ") {
            oxBridge[0].add("X")
            oxBridge[1].add(" ")
        }
    }

    private fun checkU(move: String, index: Int) {
        if (move == bridge[0][index]) {
            oxBridge[0].add("O")
            oxBridge[1].add(" ")
            correctDirection++
        } else if (bridge[1][index] == " ") {
            oxBridge[0].add(" ")
            oxBridge[1].add("X")
        }
    }

    fun move(move: String, index: Int) {
        checkU(move, index)
        checkD(move, index)
    }
}
