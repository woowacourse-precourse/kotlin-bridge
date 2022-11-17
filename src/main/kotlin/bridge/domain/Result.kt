package bridge.domain

import bridge.util.FAIL_MESSAGE
import bridge.util.SUCCESS_MESSAGE

enum class Result(val message: String) {
    SUCCESS(SUCCESS_MESSAGE),
    FAIL(FAIL_MESSAGE)
}