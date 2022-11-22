package bridge.model

enum class BridgeGameState(private val text: String) {
    PASS("성공"),
    FAIL("실패"),
    ONGOING("진행중");

    override fun toString() = this.text
}
