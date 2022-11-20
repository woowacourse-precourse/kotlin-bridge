package bridge.controller

import bridge.utils.BridgeValidator
import bridge.view.OutputView
import java.lang.IllegalArgumentException

class ValidatorController(private val outputView: OutputView) {
    fun validateBridgeSize(input: String): Boolean {
        val validator = BridgeValidator()
        return try {
            validator.validate(input)
            true
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message ?: DEFAULT_ERROR_MESSAGE)
            false
        }
    }

    companion object {
        const val DEFAULT_ERROR_MESSAGE = "에러가 발생하였습니다."
    }
}