package bridge.domain

class Bridge(private val bridge: List<String>) {
    fun match(stage: Int, select: String): Boolean {
        return bridge[stage] == select
    }

    fun finishCrossBridge(stage: Int): Boolean {
        return bridge.size == stage
    }
}