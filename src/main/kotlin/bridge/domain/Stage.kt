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

        fun makeUpBridgeMap(stage: Stage): String {
            if (stage == UP || stage == UP_FAIL) {
                return stage.isClearStage
            }
            return " "
        }

        fun makeDownBridgeMap(stage: Stage): String {
            if (stage == DOWN || stage == DOWN_FAIL) {
                return stage.isClearStage
            }
            return " "
        }
    }
}