package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    var count: Int = 1
    var msg = 0
    var retryCount = 0
    fun GuideSet(): List<String> {
        val size = guide().Guide()
        val bridgecheck = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
        return bridgecheck
    }

    fun move(bridgecheck: List<String>): Int {
        val bridgeUpList = mutableListOf<String>()
        val bridgeDownList = mutableListOf<String>()
        for (i in 0..bridgecheck.size - 1) {
            guide().bridgeList(bridgecheck[i],bridgeUpList,bridgeDownList)
            msg += retry(bridgecheck, bridgeUpList, bridgeDownList)
            if (msg >= 1) {
                count += 1
                break
            }
        }
        if (msg < 1) guide().moveresult()
        return count
    }

    fun retry(bridgecheck: List<String>, bridgeUpList: MutableList<String>, bridgeDownList: MutableList<String>): Int {
        if (bridgeUpList.contains("X") || bridgeDownList.contains("X")) {
            val restart = guide().restart()
            if (restart == "R") move(bridgecheck)
            if (restart == "Q") guide().retryresult()
            retryCount += 1
        }
        return retryCount
    }


    fun BridgUp(bridgeCheck: String, bridgeChoose: String): String {
        var MapUp = "   "
        if (bridgeCheck == "U")
            if (bridgeChoose == "U") MapUp = " O "
        if (bridgeCheck == "D")
            if (bridgeChoose == "U") MapUp = " X "
        return MapUp
    }

    fun BridgDown(bridgeCheck: String, bridgeChoose: String): String {
        var MapDown = "   "
        if (bridgeCheck == "U")
            if (bridgeChoose == "D") MapDown = " X "
        if (bridgeCheck == "D")
            if (bridgeChoose == "D") MapDown = " O "
        return MapDown
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move() {}

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
