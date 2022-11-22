package bridge

var retryCount = 1
fun main() {
    try{
        val bridgeAnswer = gameCycleFirst()
        val movedResult = gameCycleSecond(bridgeAnswer)
        gameCycleThird(bridgeAnswer,movedResult)
    } catch (e: IllegalArgumentException) {
        println(ErrorMessage.FORMATION.message)
    } catch (e: NumberFormatException) {
        println(ErrorMessage.FORMATION.message)
    }
}
