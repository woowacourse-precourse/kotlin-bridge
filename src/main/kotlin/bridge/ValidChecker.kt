package bridge

private const val OK =false
private const val WRONG= true

object ValidChecker {

    fun checkBridgeSize(size:Int){
        if(size in 3..20){
            return
        }
        throw IllegalArgumentException()
    }
    fun checkUorD(choice:String){
        if(choice!="U" && choice!="D"){
            throw IllegalArgumentException()
        }
    }

    fun checkRorQ(coin:String):Boolean{
        if(coin=="R") return true
        if(coin=="Q") return false

        throw IllegalArgumentException()
    }
}