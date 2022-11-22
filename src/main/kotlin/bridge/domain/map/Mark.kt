package bridge.domain.map

import bridge.util.constant.CORRECT_MARK
import bridge.util.constant.DEFAULT_MARK
import bridge.util.constant.WRONG_MARK

enum class Mark(val mark: Char) {
    CORRECT(CORRECT_MARK),
    WRONG(WRONG_MARK),
    DEFAULT(DEFAULT_MARK);
}