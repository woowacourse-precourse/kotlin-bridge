package bridge

class InputView {

    fun readBridgeSize(): Int {
        val bridgeSize = readLine()!!.toInt()
        return bridgeSize
    }

    fun readMoving(): String {
        val moving = readLine()!!
        return moving
    }

    fun readGameCommand(): String {
        val gameCommand = readLine()!!
        return gameCommand
    }
}