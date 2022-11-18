package bridge

object BridgeException {

    fun checkNumber(word : String){
        require(word.toIntOrNull()!=null){BridgeMessage.InputNumberError.word}
    }

    fun sizeCheck(size : Int){
        require(size in BridgeParameter.BridgeMinLength.value ..BridgeParameter.BridgeMaxLength.value){BridgeMessage.SizeError.word}
    }

    fun isitUorD(word : String){
        require(word=="U" || word=="D"){BridgeMessage.InputMovingError.word}
    }




}