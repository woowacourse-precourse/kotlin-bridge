package bridge.util

class InputVaildator {

    fun checkNullBridgeSize(userInputNumber:String?){
        userInputNumber ?: println("[Error]")
        if (userInputNumber!!.isEmpty()||userInputNumber.length>2){
            throw IllegalArgumentException()
        }
    }

}