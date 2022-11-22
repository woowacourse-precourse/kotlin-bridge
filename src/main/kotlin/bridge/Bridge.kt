package bridge

import bridge.constant.*

class Bridge(private val bridge:List<String>){
    private var playerLocation=-1
    private val roadUntilNow= RoadMap()
    private var failFlag=false

    fun movePlayer(playerInput: String){
        if(bridge[playerLocation+1]==playerInput) {
            roadUntilNow.addSuccessRoad(playerInput)
        }else{
            roadUntilNow.addFailRoad(playerInput)
            failFlag=true
        }

        playerLocation++
    }

    fun checkGameEnd() :Int{
        return if(playerLocation==(bridge.size-1) && !failFlag) END
        else if(failFlag) WRONG
        else CORRECT
    }

    fun getRoadUntilNow(): RoadMap {
        return roadUntilNow
    }
    fun getFailFlag():Boolean{
        return failFlag
    }


}