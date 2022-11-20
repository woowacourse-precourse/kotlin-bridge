package bridge

data class ResponsePacket(private val responseMessage: String, private val nextRequestType: RequestType) {
    fun popResponseMessage(): String {
        return responseMessage
    }
    fun popAdditionalMessage(): RequestType {
        return nextRequestType
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