package bridge.exceptions

class InvalidRequestException(override val message: String) : Exception(message)
class NullBridgeException(override val message: String) : Exception(message)
class RequestFormatException(override val message: String) : Exception(message)
class InvalidRangeException(override val message: String) : Exception(message)