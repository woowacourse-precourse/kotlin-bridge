package bridge.util

import bridge.domain.map.Mark
import bridge.util.constant.BRIDGE_POSTFIX
import bridge.util.constant.BRIDGE_PREFIX
import bridge.util.constant.BRIDGE_SEPARATOR

fun List<Mark>.convertAsBridgeRoute(): String =
    map { mark -> mark.mark }
    .joinToString(BRIDGE_SEPARATOR, BRIDGE_PREFIX, BRIDGE_POSTFIX)
