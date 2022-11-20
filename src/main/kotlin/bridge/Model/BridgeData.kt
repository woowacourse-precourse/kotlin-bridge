package bridge.Model

object BridgeData {
    var bridgeSize = 0
    var bridgeShape = listOf<String>()
    var bridgeLocation = 0

    fun getShape(location: Int): String{
        return bridgeShape[location]
    }
}