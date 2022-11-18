package bridge

fun main() {
    try {
        BridgeGameManager.GameStart()
    }
    catch(error : IllegalArgumentException){
        println(error.message)
    }
}
