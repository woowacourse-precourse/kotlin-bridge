package bridge

class playBridgeGameTest {
    val OV = OutputView()
    val IV = InputView()
    val BG = BridgeGame()

    fun bridgeGameStart() : List<String> {
        OV.printStartGame()
        OV.inputBridgeLength()
        val size = IV.readBridgeSize()
        val bridge = BridgeMaker(bridgeNumberGenerator = BridgeRandomNumberGenerator()).makeBridge(size)
        println(bridge) // 나중에 지우면 됨
        return bridge
    }

    fun duringGame(bridge: List<String>) {
        OV.chooseMove()
        var choose = IV.readMoving()
        println(BG.move(choose, bridge, index=0))
    }
}