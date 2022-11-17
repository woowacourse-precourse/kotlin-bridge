package bridge

class Bridge(private val bridge: List<BridgeStep>) {
    init {
        require(!bridge.contains(BridgeStep.FAIL)) {

        }
    }
}