package bridge.model

sealed class BridgeStatus(private val direction: String) {
    class FINISH(direction: String) : BridgeStatus(direction)
    class SUCCESS(direction: String) : BridgeStatus(direction)
    class FAIL(direction: String) : BridgeStatus(direction)

    fun getDirection(): String = direction

}

fun BridgeStatus.isFinish(action: () -> Unit) {
    if (this is BridgeStatus.FINISH) {
        action()
    }
}

fun BridgeStatus.isSuccess(action: () -> Unit) {
    if (this is BridgeStatus.SUCCESS) {
        action()
    }
}

fun BridgeStatus.isFail(action: () -> Unit) {
    if (this is BridgeStatus.FAIL) {
        action()
    }
}