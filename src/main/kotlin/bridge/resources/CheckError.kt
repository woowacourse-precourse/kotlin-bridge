package bridge.resources

fun String.getIntRangeOrError(): Int {
    requireNotNull(this.toIntOrNull()) { ERROR_INPUT_VALUE_NUMBER_ONLY }
    require(this.toInt() in BRIDGE_LENGTH_MIN..BRIDGE_LENGTH_MAX) { ERROR_INPUT_VALUE_BRIDGE_LENGTH }
    return this.toInt()
}

fun String.getMovingOrError(): String {
    require(this == BRIDGE_TOP_LINE_CHAR || this == BRIDGE_BOTTOM_LINE_CHAR) { ERROR_INPUT_VALUE_NEXT_MOVING }
    return this
}

fun String.getRetryOrError(): String {
    require(this == BRIDGE_RETRY || this == BRIDGE_QUIT) { ERROR_INPUT_VALUE_RETRY_OR_QUIT }
    return this
}