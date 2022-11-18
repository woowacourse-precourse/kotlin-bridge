package bridge.util

import bridge.domain.Mark

fun List<Mark>.convertAsBridgeRoute(): String =
    map { mark -> mark.mark }
    .joinToString(BRIDGE_SEPARATOR, BRIDGE_PREFIX, BRIDGE_POSTFIX)
