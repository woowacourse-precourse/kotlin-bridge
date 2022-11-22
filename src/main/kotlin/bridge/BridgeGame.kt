package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * A,B,C,D 각각의 의미는 다음과 같다.
     *
     * A: [ O ] B: [   ] C: [ X ] D: [   ]
     *    [   ]    [ O ]    [   ]    [ X ]
     */
    fun move(upDown : String,bridge :String):String {
        if(upDown==bridge){
            if(upDown == "U")
                return "A"
            return "B"
        }
        if(upDown == "U")
            return "C"
        return "D"
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry(readGame:String,bridge: MutableList<String>):Boolean {
        if(readGame == "R") {
            bridge.clear()
            return true
        }
        return false
    }
}
