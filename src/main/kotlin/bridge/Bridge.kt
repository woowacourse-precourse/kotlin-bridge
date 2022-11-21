package bridge

class Bridge(private val size:Int){
    private val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    private val bridge = BridgeMaker(bridgeRandomNumberGenerator).makeBridge(size)

    fun crossable(index:Int,playerMove:String):Boolean{
        if(bridge[index] == playerMove)
            return true
        return false
    }

    fun getSize():Int {
        return size
    }
}