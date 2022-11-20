package bridge.service

import bridge.util.constant.FAIL_MESSAGE
import bridge.util.constant.SUCCESS_MESSAGE

enum class Result(val message: String) {
    SUCCESS(SUCCESS_MESSAGE),
    FAIL(FAIL_MESSAGE)
}