package bridge

fun main() {
    try {
        GameSimulation().gameSimulation()
    } catch (e : Exception){
        println(e.message)
    }
}
