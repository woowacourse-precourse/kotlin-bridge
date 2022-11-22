package bridge.resources

fun StringBuilder.makeNewRoute() {
    this.clear()
    this.append(BRIDGE_ROUTE_START_SYMBOL)
}

fun StringBuilder.setCloseRoute() {
    this.deleteAt(this.lastIndex)
    this.append(BRIDGE_ROUTE_END_SYMBOL)
}

fun StringBuilder.updateSelectedRoute(isCorrectMoving: Boolean = true) {
    if (isCorrectMoving)
        this.append(" $BRIDGE_SELECT_POSITION_PERMIT_CHAR ")
    else
        this.append(" $BRIDGE_SELECT_POSITION_DENIED_CHAR ")
    this.append(BRIDGE_DELIMITER_BETWEEN_MOVING)
}

fun StringBuilder.updateNotSelectedRoute() {
    this.append("   ")
    this.append(BRIDGE_DELIMITER_BETWEEN_MOVING)
}