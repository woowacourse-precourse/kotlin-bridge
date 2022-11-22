package bridge

class BridgeGameUtils {
    private var inputView = InputView()
    private var outputView = OutputView()
    private val bridge = mutableListOf<String>()
    private val root = mutableListOf<String>()
    private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

    fun start(): Int {
        return inputView.readBridgeSize()
    }

    fun setBridge(size: Int) {
        bridge.addAll(bridgeMaker.makeBridge(size))
    }

    fun executeTurn(): Boolean {
        while(true) {

        }
    }

    fun restart(): Boolean {

    }
}