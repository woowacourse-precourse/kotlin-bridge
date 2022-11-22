package bridge

class Bridge(private val bridge: List<String>) {
    init {
    }

    fun getCurrentStepStatus(step: String, index: Int): Boolean {
        return bridge[index] == step
    }

    fun getBridgeDone(index: Int): Boolean {
        return bridge.size == index
    }
}