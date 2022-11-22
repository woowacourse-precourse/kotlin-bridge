package bridge.domain.data

enum class BridgeKeyword(val keyword: String) {
    PASS("O"),
    FAIL("X"),
    UP("U"),
    DOWN("D"),
    BLANK(" "),
    RETRY("R"),
    QUIT("Q")
}

enum class BridgeNumber(val number: Int) {
    ONE(1),
    ZERO(0),
    MAX_BRIDGE_SIZE(20),
    MIN_BRIDGE_SIZE(3)
}
