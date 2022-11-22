package bridge.data

import bridge.consol.Message

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

    fun partition() {
        upSide += Message.PARTITION
        downSide += Message.PARTITION
    }

    fun drawUp(hit: String) {
        upSide += " $hit "
        downSide += Message.BLANK
    }
    fun drawDown(hit: String) {
        upSide += Message.BLANK
        downSide += " $hit "
    }
}