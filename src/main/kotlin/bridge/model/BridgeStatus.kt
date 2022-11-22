package bridge.model

sealed class BridgeStatus(private val direction: String) {
    
    class FINISH(direction: String) : BridgeStatus(direction)
    class SUCCESS(direction: String) : BridgeStatus(direction)
    class FAIL(direction: String) : BridgeStatus(direction)

    fun getDirection(): String = direction

    fun isFinish(action: () -> Unit) {
        if (this is FINISH) {
            action()
        }
    }

    fun isSuccess(action: () -> Unit) {
        if (this is SUCCESS) {
            action()
        }
    }

    fun isFail(action: () -> Unit) {
        if (this is FAIL) {
            action()
        }
    }
}