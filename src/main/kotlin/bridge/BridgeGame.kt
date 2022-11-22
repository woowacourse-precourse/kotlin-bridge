package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private var count: Int = 1
    private var result = 0
    private var setBase = 0
    fun guideSet(): List<String> {
        val size = Guide().guideInfo()
        return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    }

    fun startBridge(checkBridge: List<String>): Int {
        val bridgeUpList = mutableListOf<String>()
        val bridgeDownList = mutableListOf<String>()
        move(checkBridge, bridgeUpList, bridgeDownList)
        if (result < 1) Guide().successGuideMsg()
        return count
    }

    fun move(checkBridge: List<String>, bridgeUpList: MutableList<String>, bridgeDownList: MutableList<String>) {
        for (Index in 0.. checkBridge.size-1) {
            val bridgeChoose = Guide().selectBridgeGuide()
            bridgeUpList.add(BridgeGame().bridgUp(checkBridge[Index], bridgeChoose))
            bridgeDownList.add(BridgeGame().bridgDown(checkBridge[Index], bridgeChoose))
            Guide().success(Index,checkBridge)
            bridgeMove(checkBridge, bridgeUpList, bridgeDownList)
            if (result >= 1) break
        }
    }

    fun bridgeMove(checkBridge: List<String>, bridgeUpList: MutableList<String>, bridgeDownList: MutableList<String>){
        Guide().bridgeList(bridgeUpList, bridgeDownList)
        result += retry(checkBridge, bridgeUpList, bridgeDownList)
    }
    fun bridgUp(bridgeCheck: String, bridgeChoose: String): String {
        var mapUp = "   "
        if (bridgeChoose == "U") {
            when (bridgeCheck) {
                "U" -> mapUp = " O "
                "D" -> mapUp = " X "
            }
        }
        return mapUp
    }

    fun bridgDown(bridgeCheck: String, bridgeChoose: String): String {
        var mapDown = "   "
        if (bridgeChoose == "D") {
            when (bridgeCheck) {
                "U" -> mapDown = " X "
                "D" -> mapDown = " O "
            }
        }
        return mapDown
    }

    fun retry(bridgecheck: List<String>, bridgeUpList: MutableList<String>, bridgeDownList: MutableList<String>): Int {
        if (bridgeUpList.contains(" X ") || bridgeDownList.contains(" X ")) {
            val restart = Guide().restart()
            retryRestart(restart,bridgecheck)
            retryQuit(restart,bridgeUpList,bridgeDownList)
            setBase += 1
        }
        return setBase
    }
    fun retryRestart(restart:String,bridgeCheck: List<String>){
        if (restart == "R") {
            startBridge(bridgeCheck)
            count += 1
        }
    }
    fun retryQuit(restart:String, bridgeUpList: MutableList<String>, bridgeDownList: MutableList<String>){
        if (restart == "Q") {
            Guide().fail()
            Guide().bridgeList(bridgeUpList, bridgeDownList)
            Guide().failGuideMsg()
        }
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

}
