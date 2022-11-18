package bridge.domain

class BridgeChecker(private val bridge: Bridge) {
    fun checkDirection(number: Int, playerDirection: String): Boolean =
        bridge.getDirection(number) == playerDirection
}