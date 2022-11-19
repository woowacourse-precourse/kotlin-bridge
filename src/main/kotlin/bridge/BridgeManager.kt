package bridge

class BridgeManager(private val inputView: InputView, private val outputView: OutputView) {
    private val bridgeSize: Int
    private val bridge: List<String>
    private val bridgeGame: BridgeGame
    private var position = 0

    init {
        println("다리 건너기 게임을 시작합니다.")
        this.bridgeSize = this.setBridgeSize()
        this.bridgeGame = BridgeGame(this.bridgeSize)
        this.bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(this.bridgeSize)
    }

    private fun setBridgeSize(): Int {
        while (true) {
            try {
                this.outputView.printBridge()
                return this.inputView.readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    private fun getMoveCommand(): String {
        while (true) {
            try {
                this.outputView.printMove()
                return inputView.readMoving()
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    fun moveBridge(position: Int) {
        val move = getMoveCommand()
        this.bridgeGame.move(this.bridge, move, position)
        val triple = Triple(position, this.bridgeGame.getUpBridge(), this.bridgeGame.getDownBridge())
        this.outputView.printMap(triple)
    }

    fun getBridgeSize() = this.bridgeSize

    fun getBridge() = this.bridge

    fun getBridgeGame() = this.bridgeGame

    fun getPosition() = this.position

}