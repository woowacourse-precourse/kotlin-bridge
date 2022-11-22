package bridge

class BridgeGameUtils {
    var inputView = InputView()
    var outputView = OutputView()
    private val bridge = ArrayList<String>()
    private val root = ArrayList<String>()

    fun start(): Int {
        return inputView.readBridgeSize()
    }

    fun executeTurn(): Boolean {

    }

    fun restart(): Boolean {

    }
}