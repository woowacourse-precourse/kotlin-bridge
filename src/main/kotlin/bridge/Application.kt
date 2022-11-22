package bridge

var retryCount = 1
fun main() {
    val bridgeAnswer = gameCycleFirst()
    val movedResult = gameCycleSecond(bridgeAnswer)
    gameCycleThird(bridgeAnswer,movedResult)
}
