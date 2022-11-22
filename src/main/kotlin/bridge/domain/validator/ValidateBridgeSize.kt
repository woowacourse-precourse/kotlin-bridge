package bridge.domain.validator

import bridge.data.InputError
import bridge.data.InputDataSource.bridgeSize
import bridge.ui.Views
import java.lang.IllegalArgumentException

class ValidateBridgeSize(
    private val views: Views = Views()
) {
    operator fun invoke() {
        do {
            try {
                views.inputView.readBridgeSize().apply {
                    require(isDigit())
                    require(toInt().isInValidRange())
                    bridgeSize = toInt()
                }
            } catch (exception: IllegalArgumentException) {
                views.outputView.printError(InputError.BridgeSizeInputError(BRIDGE_LENGTH_EXCEPTION))
            }
        } while (bridgeSize == 0)
    }

    private fun String.isDigit(): Boolean {
        return this.all { it.isDigit() }
    }

    private fun Int.isInValidRange(): Boolean {
        return this in BRIDGE_MIN_LENGTH..BRIDGE_MAX_LENGTH
    }

    companion object {
        const val BRIDGE_MIN_LENGTH = 3
        const val BRIDGE_MAX_LENGTH = 20
        const val BRIDGE_LENGTH_EXCEPTION = "다리 길이는 3부터 20 사이의 숫자여야 합니다."
    }
}