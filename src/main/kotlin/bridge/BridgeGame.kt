package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    fun move(userInput: String, bridgeCurrentPosition: Int, bridge: List<String>): Boolean =
        bridge[bridgeCurrentPosition] == userInput

    fun retry(userInput: String): GameState = GameState.convertStringCodeToValue(userInput)
}
