package bridge

class InputView {

    fun readBridgeSize(): Int {
        val bridgeSize = readLine()!!.toInt()
        ErrorCheck().checkBridgeSize(bridgeSize.toString())
        ErrorCheck().checkBridgeRange(bridgeSize)
        return bridgeSize
    }

    fun readMoving(): String {
        val moving = readLine()!!
        ErrorCheck().checkReadMoving(moving)
        return moving
    }

    fun readGameCommand(): String {
        val gameCommand = readLine()!!
        ErrorCheck().checkCommand(gameCommand)
        return gameCommand
    }
}