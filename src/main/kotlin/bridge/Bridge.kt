package bridge

class Bridge (size : Int = 0) {
    val bridge : MutableList<String> = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size).toMutableList()
}