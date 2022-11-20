package bridge

import bridge.exceptions.InvalidRangeException
import bridge.exceptions.RequestFormatException

val outputView = OutputView()
val inputView = InputView()

fun main() {
    val bridgeGame = BridgeGame()
    var responsePacket = bridgeGame.respondToRequest(RequestType.LAUNCH)
    var responsePacketFor = ResponsePacketFor(RequestType.LAUNCH, responsePacket)

    while (true) {
        if (isEnd(responsePacketFor)) break
        printProgressMessage(responsePacketFor)

        responsePacket = getResponsePacketFrom(bridgeGame, responsePacketFor)
        responsePacketFor = ResponsePacketFor(responsePacketFor.popAdditionalMessage(), responsePacket)
    }
}

fun isEnd(responsePacketFor: ResponsePacketFor): Boolean {
    if (responsePacketFor.popAdditionalMessage() == RequestType.NONE) {
        outputView.printResult(responsePacketFor.popResponseMessage())
        return true
    }
    return false
}

fun printProgressMessage(responsePacketFor: ResponsePacketFor) {
    when (responsePacketFor.requestType) {
        RequestType.MOVE -> outputView.printMap(responsePacketFor.popResponseMessage())
        else -> outputView.printGuidMessage(responsePacketFor.popResponseMessage())
    }
}

fun readLineIfUserInputNeeded(responsePacketFor: ResponsePacketFor): String {
    var userInput = ""
    if (responsePacketFor.popAdditionalMessage() != RequestType.GUID_MESSAGE) {
        userInput = inputView.readLineAbout(responsePacketFor.popAdditionalMessage())
    }
    return userInput
}

fun getResponsePacketFrom(
    bridgeGame: BridgeGame,
    responsePacketFor: ResponsePacketFor
): ResponsePacket {
    var responsePacket: ResponsePacket
    while (true) try {
        val userInput = readLineIfUserInputNeeded(responsePacketFor)
        responsePacket = bridgeGame.respondToRequest(responsePacketFor.popAdditionalMessage(), userInput)
        return responsePacket
    } catch (e: InvalidRangeException) {
        outputView.log(e.message)
    } catch (e: RequestFormatException) {
        outputView.log(e.message)
    }
}