package bridge

fun main() {
    // bridgeGame을 생성하고 게임을 시작 - start() 실행
    val bridgeGame = BridgeGame()
    bridgeGame.start()
    var position = 0
    // 반복문으로 move()
    while(true) {
        // move를 통해 이동여부를 받은 후 false를 받으면 retry() 실행
        val isMovable = bridgeGame.move(position++)
        // 이동에 성공할 때마다 position를 증가해 다리 길이와 일치할 경우 반복문에서 나가고
    }

    // 게임 결과 gameOver()를 실행한다.
}
