package bridge

class Util {
    fun isInt(input: String): Boolean{
        val num:Int? = input.toIntOrNull()
        if(num==null){
            println(Error.NOT_INT.info)
            return false
        }

        return true
    }
    fun isInRange(input : Int): Boolean{
        if(input>=3 && input<=20)
            return true
        throw IllegalArgumentException(Error.NOT_IN_RANGE.info)
    }

    fun isUD(input : String):Boolean{
        if(input=="U" || input=="D")
            return true
        throw IllegalArgumentException(Error.NOT_UD.info)
    }
    fun isRQ(input : String): Boolean{
        if(input=="R" || input=="Q")
            return true
        throw IllegalArgumentException(Error.NOT_RQ.info)
    }
}