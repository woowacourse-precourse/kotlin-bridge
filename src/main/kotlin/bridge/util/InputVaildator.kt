package bridge.util

class InputVaildator {

    fun checkNullBridgeSize(userInputNumber:String?){
        userInputNumber ?: println("[Error]")
        if (userInputNumber!!.isEmpty()||userInputNumber.length>2){
            throw IllegalArgumentException()
        }
    }

    //영어 문구 입력 널 값 길이 확인 기능
    fun checkNullBridgeString(userInputNumber:String?){
        userInputNumber ?: println("[Error]")
        if (userInputNumber!!.isEmpty()||userInputNumber.length>1){
            throw IllegalArgumentException()
        }
    }

}