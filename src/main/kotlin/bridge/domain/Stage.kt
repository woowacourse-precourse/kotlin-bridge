package bridge.domain

enum class Stage(val upOrDown: String, val isClearStage: String) {
    UP("U", "O"),
    DOWN("D", "O"),
    UP_FAIL("U","X"),
    DOWN_FAIL("D", "X");
}