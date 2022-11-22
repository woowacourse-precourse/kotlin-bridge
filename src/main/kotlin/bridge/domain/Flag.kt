package bridge.domain

import bridge.constants.String.Companion.STRING_FAIL
import bridge.constants.String.Companion.STRING_PLAYING
import bridge.constants.String.Companion.STRING_SUCCESS

enum class Flag(val string: String) {
    CLEAR(STRING_SUCCESS),
    FAIL(STRING_FAIL),
    PLAYING(STRING_PLAYING)
}