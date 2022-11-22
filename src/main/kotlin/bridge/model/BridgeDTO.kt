package bridge.model

class BridgeDTO(private val bridge: List<String>) {
    fun getBridge(): List<String> {
        return bridge
    }
}