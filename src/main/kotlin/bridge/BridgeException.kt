package bridge

object BridgeException {

    fun CheckitisNumber(word : String){
        require(word.toIntOrNull()!=null){BridgeMessage.inputNumberError.word}
    }

    fun SizeCheck(size : Int){
        require(size in BridgeParameter.BridgeMinLength.value ..BridgeParameter.BridgeMaxLength.value){BridgeMessage.SizeError.word}
    }




}