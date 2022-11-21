package bridge.domain

import bridge.resources.ERROR_ALREADY_ARRIVED

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridgeGameInfo: BridgeGameInfo, userSelect: String) {
        bridgeGameInfo.run {
            require(stage.size < bridge.size) { ERROR_ALREADY_ARRIVED }
            stage = stage.plus(userSelect == bridge[stage.size].type)
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(bridgeGameInfo: BridgeGameInfo) {
        bridgeGameInfo.run {
            stage = emptyList()
            countOfTry++
        }
    }
}
