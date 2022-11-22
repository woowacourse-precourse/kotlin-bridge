package bridge.io

import bridge.resources.DOWN
import bridge.resources.QUIT_COMMAND
import bridge.resources.RETRY_COMMAND
import bridge.resources.UP

class ValidChecker {

    fun checkBridgeSize(size:Int){
        if(size in 3..20){
            return
        }
        throw IllegalArgumentException()
    }
    fun checkUorD(choice:String){
        if(choice!=UP && choice!= DOWN){
            throw IllegalArgumentException()
        }
    }

    fun checkRorQ(coin:String):Boolean{
        if(coin== RETRY_COMMAND) return true
        if(coin== QUIT_COMMAND) return false

        throw IllegalArgumentException()
    }
}