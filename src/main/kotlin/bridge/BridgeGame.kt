package bridge

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
    private var userInList = listOf<String>()

    var upstr: String = "[ "
    var downstr: String = "[ "
    var flag = 0
    var gamecnt : Int = 0
    fun move(bridgeObj : BridgeMaker, ch: String) {
        userInList.plus(ch)
        val bridge = bridgeObj.bridge
        for (i in userInList.indices){ flag = updownString(i, bridge) }

    }

    fun updownString(i : Int, bList: List<String>): Int{
        return if (bList[i] == userInList[i]){
            if (bList[i] == "U" && i < userInList.size-1) upstr.plus("O | ")
            else if (bList[i] == "D" && i < userInList.size-1) downstr.plus("O | ")
            else if (bList[i] == "U" && i == userInList.size-1) upstr.plus("O ]")
            else if (bList[i] == "D" && i < userInList.size-1) downstr.plus("O ]")
            0
        }else{
            if(userInList[i] == "U") upstr.plus("X ]")
            else downstr.plus("X ]")
            1
        }

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(ch : String) {
        if (ch == "R") {
            gamecnt +=1
        }else{
            OutputView().printResult(this)
        }
    }
}
