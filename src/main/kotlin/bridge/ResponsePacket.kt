package bridge

data class ResponsePacket(private val responseMessage: String, private val nextRequestType: RequestType) {
    fun popMessageToPrint(): String {
        return responseMessage
    }
    fun popAdditionalMessage(): RequestType {
        return nextRequestType
    }
}