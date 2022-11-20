package bridge.Model

object BridgeData {
    var bridgeSize = 0
    var bridgeShape = listOf<String>()
    var bridgeLocation = 0
    var roundResult = mutableListOf<BridgeResult>()
    var isOver = false

    fun getShape(location: Int): String {
        return bridgeShape[location]
    }
}