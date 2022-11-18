package bridge

fun main() {
    try {
        BridgeGameManager.gameStart()
    }
    catch(error : IllegalArgumentException){
        println(error.message)
    }
}
