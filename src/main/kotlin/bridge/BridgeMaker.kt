package bridge

import bridge.constant.DOWN_SIDE
import bridge.constant.UP_SIDE


class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridgeList= mutableListOf<String>()
        repeat(size){
            val randomNumber=bridgeNumberGenerator.generate()

            if(randomNumber==0){
                bridgeList.add(DOWN_SIDE)
            }
            else{
                bridgeList.add(UP_SIDE)
            }
        }

        return bridgeList
    }
}
