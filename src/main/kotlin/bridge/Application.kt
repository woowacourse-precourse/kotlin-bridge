package bridge


// todo refactor 마무리한 것들 기능 구현 목록 체크 표시 하기
fun main() {
    val bridgeGame = BridgeGame()
    bridgeGame.start()

    var retry = true
    do {
        val isMovable = bridgeGame.move()
        if (isMovable.not())
            retry = bridgeGame.retry()

        val arrived = bridgeGame.arrivedBridgeEnd()
    } while (arrived.not() && retry) // 도착하지 못했고, 재시작할 거라면 계속 반복 / 하나라도 아니라면 반복문 나가기.

    bridgeGame.gameOver(retry)
}
