package bridge

class Util {
    fun isInt(input: String): Boolean{
        val num:Int? = input.toIntOrNull()
        if(num==null)
            throw IllegalArgumentException(Error.NOT_INT.info)
        return true
    }
    fun isInRange(input : Int): Boolean{
        return true
    }

    fun isUD(input : String):Boolean{
        return true
    }
    fun isRQ(input : String): Boolean{
      return true
    }
}