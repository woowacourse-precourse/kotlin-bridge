package bridge

fun main() {
    try{
        BridgeGamePlay().startGame()
    }catch( e : Exception){
        println(e)
    }
}
