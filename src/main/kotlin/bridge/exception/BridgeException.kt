package bridge.exception


class BridgeException (private val inp: String?) {

    /**
     * 입력값이 Null인지 체크하는 메서드
     */
    private fun nullCheck() {
        if (inp.isNullOrBlank())
            throw IllegalArgumentException()
    }

    /**
     * 다리의 길이가 3~20 사이의 정수인지 확인하는 메서드
     */
    fun toSize(): Int {
        nullCheck()
        val bridgeSize = inp!!.toInt()
        if (bridgeSize !in 3..20) throw IllegalArgumentException()
        return bridgeSize
    }

    /**
     * 이동할 칸의 입력값이 제대로 되었는지 확인하는 메서드
     * "U" 또는 "D"여야 함
     */
    fun toMoving(): String {
        nullCheck()
        if (inp == "U" || inp == "D") return inp
        throw IllegalArgumentException()
    }
    /**
     * 사용자가 재시도 여부를 제대로 입력했는디 확인하는 메서드
     * "R" 또는 "Q"여야 함
     */
    fun toGameCommand(): String {
        nullCheck()
        if (inp == "R" || inp == "Q") return inp
        throw IllegalArgumentException()
    }

}