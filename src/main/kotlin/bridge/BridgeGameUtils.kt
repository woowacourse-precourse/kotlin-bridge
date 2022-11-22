package bridge

class BridgeGameUtils {
    private var inputView = InputView()
    private var outputView = OutputView()
    val bridge = mutableListOf<String>()
    val root = mutableListOf<String>()
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
            state = isFinished()
        }
        return cnt == bridge.size
    }

    private fun isFinished(): Boolean {
        return bridge.subList(0, root.size) == root && bridge.size != root.size
    }

    fun finish(cnt: Int): Boolean {
        return outputView.printResult(bridge, root, cnt)
    }

    fun restart(): Boolean {
        if(bridge == root) {
            return false
        }
        root.clear()
        return inputView.readGameCommand() == "R"
    }
}