package bridge

fun main() {
    val user = playBridgeGameTest()
    val bridge = user.bridgeGameStart() // 다리는 최초 한번 생성
    var index=0
    while (true){
        if (bridge.size==index) break
        index=user.duringGame(bridge, index)
        user.duringGame2(index)
    }
}
