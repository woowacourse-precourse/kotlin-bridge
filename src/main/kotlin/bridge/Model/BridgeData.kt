package bridge.Model

/*
* UP_WIN - 플레이어: U, 다리 상태: U
* UP_LOSE - 플레이어: U, 다리 상태: D
* DOWN_WIN - 플레이어: D, 다리 상태: D
* DOWN_LOSE - 플레이어: D, 다리 상태: U
* */

enum class BridgeResult(
    val upState: String,
    val downState: String
) {
    UP_WIN("O", " "),
    UP_LOSE("X", " "),
    DOWN_WIN(" ", "O"),
    DOWN_LOSE(" ", "X")
}

object BridgeData {
    var bridgeSize = 0
    var bridgeShape = listOf<String>()
    var bridgeLocation = 0
    var roundResult = mutableListOf<BridgeResult>()
    var isPlay = true

    fun getShape(location: Int): String {
        return bridgeShape[location]
    }

    fun resetData() {
        bridgeLocation = 0
        roundResult.clear()
        isPlay = true
    }
}