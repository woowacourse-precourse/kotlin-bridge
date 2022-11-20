package bridge

import camp.nextstep.edu.missionutils.Console
val bridgeGame = BridgeGame()
val outputView = OutputView()
fun main() {

    var responsePacket = bridgeGame.respondToRequest(RequestType.LAUNCH)
    var responsePacketFor = ResponsePacketFor(RequestType.LAUNCH, responsePacket)

    while (true) {
        if(responsePacketFor.requestType == RequestType.LAUNCH) {
            outputView.printGuidMessage(responsePacketFor.popResponseMessage())
        }
        else if(responsePacketFor.popAdditionalMessage() == RequestType.NONE) {
            outputView.printResult(responsePacketFor.popResponseMessage())
            break
        }
        else if(responsePacketFor.requestType == RequestType.NOW_STATE_MESSAGE) {
            outputView.printGuidMessage(responsePacketFor.popResponseMessage())
        }
        else if(responsePacketFor.requestType == RequestType.MOVE) {
            outputView.printMap(responsePacketFor.popResponseMessage())
        }

        var userInput = ""
        if(responsePacketFor.popAdditionalMessage() != RequestType.NOW_STATE_MESSAGE) {
            userInput = inputView.readLineAbout(responsePacketFor.popAdditionalMessage())
        }
        responsePacket = bridgeGame.respondToRequest(responsePacketFor.popAdditionalMessage(), userInput)
        responsePacketFor = ResponsePacketFor(responsePacketFor.popAdditionalMessage(), responsePacket)
    }
}

class ResponsePacketFor(val requestType: RequestType, val responsePacket: ResponsePacket) {
    fun popResponseMessage(): String {
        return responsePacket.popResponseMessage()
    }
    fun popAdditionalMessage(): RequestType {
        return responsePacket.popAdditionalMessage()
    }
}
