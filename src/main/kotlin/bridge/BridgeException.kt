package bridge

class BridgeException {

    fun readBridgeSizeError(): Int {
        val readBridge : Int
        try {
            readBridge=InputView().readBridgeSize()
        } catch(e : IllegalArgumentException) {
            println("[ERROR] 숫자를 입력해주십시오")
            return readBridgeSizeError()
        }
        return readBridgeSizeOverNumError(readBridge)
    }

    private fun readBridgeSizeOverNumError(readBridge: Int): Int{
        try{
            if(readBridge > 20 || readBridge <3)
                throw IllegalArgumentException()
        }catch (e:IllegalArgumentException){
            println("[ERROR] 3이상 20이하의 숫자를 입력해주십시오")
            return readBridgeSizeError()
        }
        return readBridge
    }
}