package bridge

class Bridge(private val bridge: List<BridgeStep>) {
    init {
        require(!bridge.contains(BridgeStep.FAIL)) {

        }
    }

    fun getCurrentStepStatue(step: BridgeStep, index: Int): Boolean {
        return bridge[index] == step
    }
}