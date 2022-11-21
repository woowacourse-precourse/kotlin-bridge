package bridge

class CheckTrue {
    fun checkBridgeLength(length : String) :Int{
       var length = length.toIntOrNull();
        if(length == null) throw IllegalArgumentException()
        if(length <3 || length>20) throw IllegalArgumentException()
        return length
    }

    fun checkMove(way : String) : String{
        if(way != "U" && way != "D") throw IllegalArgumentException()
        return way
    }


}