package bridge

object BridgeCalculate {

    fun bridgeMaking(size: Int) : List<Int>{
        val bridge = mutableListOf<Int>()
        val randomizer = BridgeRandomNumberGenerator()
        for(number:Int in 0 .. size)
            bridge.add(randomizer.generate())

        return bridge.toList()
    }

}