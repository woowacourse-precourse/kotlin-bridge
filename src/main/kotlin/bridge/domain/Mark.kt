package bridge.domain

import bridge.util.CORRECT_MARK
import bridge.util.DEFAULT_MARK
import bridge.util.WRONG_MARK

enum class Mark(val mark: Char) {
    CORRECT(CORRECT_MARK),
    WRONG(WRONG_MARK),
    DEFAULT(DEFAULT_MARK);
}