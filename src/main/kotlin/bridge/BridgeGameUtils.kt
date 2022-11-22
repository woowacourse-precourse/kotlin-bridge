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
        var state = true
        var cnt = 0
        while(state) {
            cnt++
            root.add(inputView.readMoving())
            outputView.printMap(bridge, root)
            state = isEqual()
        }
        return cnt == bridge.size
    }

    private fun isEqual(): Boolean {
        return bridge.subList(0, root.size - 1) == root
    }

    fun finish(cnt: Int) {
        outputView.printResult(bridge, root, cnt)
    }

    fun restart(): Boolean {
        return inputView.readGameCommand() == "R"
    }
}