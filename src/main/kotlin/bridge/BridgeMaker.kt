package bridge

import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_LOWER_INCLUSIVE
import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_UPPER_INCLUSIVE

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        var bridge = mutableListOf<String>()
        for(i in 1..size){
            val randomNum = bridgeNumberGenerator.generate()
            if(randomNum == RANDOM_LOWER_INCLUSIVE) bridge.add("D")
            else if(randomNum == RANDOM_UPPER_INCLUSIVE) bridge.add("U")
        }
        return bridge
    }

}