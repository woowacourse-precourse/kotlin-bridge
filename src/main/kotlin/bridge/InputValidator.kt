package bridge

object InputValidator {

    fun validateBridgeSize(bridgeSize: Int) =
        require(bridgeSize in 3..20) {
            println(Error.BRIDGE_RANGE_ERROR)
        }



}