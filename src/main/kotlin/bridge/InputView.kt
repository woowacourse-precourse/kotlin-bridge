package bridge

class InputView {

    fun readBridgeSize(): Int {
        val bridgeSize = readLine()!!.toInt()
        return bridgeSize
    }

    fun readMoving(): String {
        return ""
    }

    fun readGameCommand(): String {
        return ""
    }
}