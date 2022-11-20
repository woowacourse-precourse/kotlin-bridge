package bridge.exceptions

class InvalidRequestException(override val message: String) : Exception(message)
class NullBridgeException(override val message: String) : Exception(message)