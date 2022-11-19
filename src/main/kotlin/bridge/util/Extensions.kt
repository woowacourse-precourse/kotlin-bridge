package bridge.util

import bridge.domain.map.Mark

fun List<Mark>.convertAsBridgeRoute(): String =
    map { mark -> mark.mark }
    .joinToString(BRIDGE_SEPARATOR, BRIDGE_PREFIX, BRIDGE_POSTFIX)
