package bridge

data class Bridge(
    var up: String = "",
    var down: String = "",
    var size: Int = 0
) {
    fun setUpBridge(result: String) {
        up += result
    }

    fun setDownBridge(result: String) {
        down += result
    }

    fun setBridgeSize() {
        size += 1
    }

    fun resetBridge() {
        size = 0
        up = ""
        down = ""
    }
}
