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
    fun move(bridgeColumns: String,userInputColumn:String):String {
        bridgeColumns.split(",").map { bridgeColumn ->
            if (bridgeColumn.first() == userInputColumn.first()) return "${getColumnResult(bridgeColumn,ONE_COLUMN_UP)},${getColumnResult(bridgeColumn,ONE_COLUMN_DOWN)}"
        }
        return " "
    }

    private fun isPassable(passableNumber: Int): String {
        return if (passableNumber == RANDOM_UPPER_INCLUSIVE) " O " else " X "
    }

    private fun getColumnResult(bridgeColumn: String, column: Char) =
        if (bridgeColumn.first() == column) isPassable(bridgeColumn.last().digitToInt())
        else "   "





    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    companion object {
        const val RANDOM_UPPER_INCLUSIVE = 1
        const val ONE_COLUMN_UP = 'U'
        const val ONE_COLUMN_DOWN = 'D'
    }

    fun retry() {}
}
