package bridge.domain.usecase

import camp.nextstep.edu.missionutils.Console

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
    // val p = listOf<String>("U1,D0", "U0,D1", "U0,D1", "U0,D1")
    fun move(bridgeRow: String, userInputRow: String): Pair<String, String> {
        if (bridgeRow == "U") return Pair(isPassable(bridgeRow, userInputRow), " ")
        return Pair(
            " ", isPassable(bridgeRow, userInputRow)
        )
    }

    private fun isPassable(bridgeRow: String, userInputRow: String): String {
        if (userInputRow == bridgeRow) return "O"
        return "X"
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun retry() {}
}
