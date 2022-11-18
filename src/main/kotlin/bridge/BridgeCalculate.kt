package bridge

object BridgeCalculate {

    fun BridgeMaking(size: Int) : List<Int>{
        val bridge = mutableListOf<Int>()
        val randomnumber = BridgeRandomNumberGenerator()
        for(number:Int in 0 .. size)
            bridge.add(randomnumber.generate())

        return bridge.toList()
    }

}