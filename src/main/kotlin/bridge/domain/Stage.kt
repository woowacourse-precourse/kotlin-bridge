package bridge.domain

enum class Stage(val upOrDown: String, val isClearStage: String) {
    UP("U", "O"),
    DOWN("D", "O"),
    UP_FAIL("U","X"),
    DOWN_FAIL("D", "X");

    companion object {
        fun getStageInform(moving: String, isClearStage: String): Stage {
            return Stage.values().filter { stage -> stage.upOrDown == moving }
                .first() { stage -> isClearStage == stage.isClearStage }
        }
    }
}