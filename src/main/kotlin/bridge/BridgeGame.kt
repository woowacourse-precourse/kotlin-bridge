package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {

    private val moves: MutableList<String> = mutableListOf()

    /**
     * @brief 사용자가 칸을 이동할 때 사용하는 메서드
     * @param idx 현재 사용자의 위치
     * @param moving 사용자가 입력한 이동 방향
     * @return 사용자가 이동한 방향에 다리가 있으면 true, 없으면 false를 반환한다.
     */
    fun move(idx: Int, moving: String): Boolean {
        moves.add(moving)
        if(moving == bridge[idx]) return true
        return false
    }

    /**
     * @brief 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry() {
        moves.clear()
    }

    /**
     * @return game 상황을 string으로 변환한 결과를 반환한다.
     */
    fun gameToString(): String {
        return gameToStringLine(true) + "\n" + gameToStringLine(false);
    }

    /**
     * @param isUpper 변환할 줄을 나타내는 변수. true면 윗줄, false면 아랫줄을 의미한다.
     * @return game 상황의 윗줄 혹은 아랫줄을 string으로 변환한 결과를 반환한다.
     */
    private fun gameToStringLine(isUpper: Boolean): String {
        var result = "[ "
        val direction = if(isUpper) "U" else "D"
        for(i in moves.indices) {
            result += moveToString(i, direction)
            result += if(i != moves.size-1) " | " else " ]"
        }
        return result
    }

    /**
     * @brief 사용자의 이동 결과를 string으로 변환한다.
     * @param index 사용자의 위치를 나타낸다.
     * @param direction 어느 줄을 변환 중인지 나타낸다. U면 윗줄, D면 아랫줄이다.
     * @return 변환 결과를 반환한다.
     */
    private fun moveToString(index: Int, direction: String): String {
        if(moves[index] != direction) return " "
        else if(moves[index] == direction && bridge[index] == moves[index]) return "O"
        else return "X"
    }
}
