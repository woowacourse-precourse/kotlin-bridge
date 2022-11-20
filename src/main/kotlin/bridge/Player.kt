package bridge

class Player {
    fun isAlive(block:String,playerMove:String):Boolean{
        if(block == playerMove)
            return true
        return false
    }
}