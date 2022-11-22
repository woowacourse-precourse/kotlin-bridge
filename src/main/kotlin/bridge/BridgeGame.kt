package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
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

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(move: String, index: Int) {
        checkU(move, index)
        checkD(move, index)
    }
}
