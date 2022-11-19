package bridge.domain

class Bridge(private val bridge: List<String>) {
    private var stage = 0

    fun match(select: String): Boolean {
        return bridge[stage++] == select
    }

    fun getBridge(): List<String> {
        return bridge
    }
}