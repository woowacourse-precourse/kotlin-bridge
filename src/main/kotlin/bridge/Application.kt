package bridge

fun main() {
    val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    print(BridgeMaker(bridgeRandomNumberGenerator).makeBridge(10))
}
