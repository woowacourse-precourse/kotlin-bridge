package bridge

class Bridge(private val bridge: List<BridgeStep>) {
    init {
        require(!bridge.contains(BridgeStep.FAIL)) {

        }
    }

    fun getCurrentStepStatus(step: BridgeStep, index: Int): Boolean {
        return bridge[index] == step
    }
}