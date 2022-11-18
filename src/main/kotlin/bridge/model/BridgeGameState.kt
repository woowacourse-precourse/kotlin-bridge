package bridge.model

enum class BridgeGameState {
    PASS {
        override fun toString() = TEXT_PASS
    },
    FAIL {
        override fun toString() = TEXT_FAil
    },
    ONGOING {
        override fun toString() = TEXT_ONGOING
    };

    companion object {
        private const val TEXT_PASS = "성공"
        private const val TEXT_FAil = "실패"
        private const val TEXT_ONGOING = "진행중"
    }
}
