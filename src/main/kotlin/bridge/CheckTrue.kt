package bridge

class CheckTrue {
    fun checkBridgeLength(length : String){
       var length = length.toIntOrNull();
        if(length == null) throw IllegalArgumentException()
        if(length <3 || length>20) throw IllegalArgumentException()
    }

}