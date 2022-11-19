package bridge.data

class BridgeMap {
    var upSide = ""
    var downSide = ""
    fun getMap(): Pair<String, String> {
        return upSide to downSide
    }

    fun clear() {
        upSide = ""
        downSide = ""
    }
}