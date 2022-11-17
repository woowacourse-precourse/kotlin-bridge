package bridge

import camp.nextstep.edu.missionutils.Console

fun main() {
    val bridgeGame = BridgeGame()
    var responsePacket = bridgeGame.respondToRequest(RequestType.LAUNCH)

    while (responsePacket.popAdditionalMessage() != RequestType.NONE) {
        println(responsePacket.popMessageToPrint())
        if (responsePacket.popAdditionalMessage() != RequestType.NOW_STATE_MESSAGE) {
            val value = Console.readLine()
            responsePacket = bridgeGame.respondToRequest(responsePacket.popAdditionalMessage(), value)
        } else
            responsePacket = bridgeGame.respondToRequest(responsePacket.popAdditionalMessage())
    }
    println(responsePacket.popMessageToPrint())
}
