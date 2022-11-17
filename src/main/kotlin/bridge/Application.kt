package bridge

fun main() {
    val user = playBridgeGameTest()
    val bridge = user.bridgeGameStart()
    user.duringGame(bridge)

}
