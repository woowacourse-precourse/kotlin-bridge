package bridge.util

import bridge.domain.Mark

fun Array<Mark>.convertAsBridgeMap(): String =
    map { mark -> mark.mark }
    .joinToString(BRIDGE_SEPARATOR, BRIDGE_PREFIX, BRIDGE_POSTFIX)
