package domain

import view.OutputView
import java.lang.IllegalArgumentException

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val outputView = OutputView()
    private var playMap = Pair<List<String>, List<String>>(arrayListOf(), arrayListOf())
    private val MESSAGE_RESULT_MAP = "최종 게임 결과"
    private val MESSAGE_SUCCESS = "성공"
    private val MESSAGE_FAILLED = "실패"
    private val MESSAGE_ERROR = "[ERROR]"

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridgeSize: Int) {
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        println(bridgeMaker)
        play(bridgeSize, bridgeMaker, 1)
    }

    private fun play(bridgeSize: Int, bridgeMaker: List<String>, numberOfGames:Int){
        for (i in 1.. bridgeSize){
            val move = OutputView().printMoving()
            if (!isMoving(i, bridgeMaker, move)) {
                retry(bridgeSize,bridgeMaker, numberOfGames)
                break
            }
        }
        result(numberOfGames)
    }


    // 현재 입력 값과 다리의 값이 같은지, 들린지
    private fun isMoving(bridgeToNow: Int, bridge: List<String>, nowMove:String): Boolean{
        // 현재까지 이동 칸 출력
        playMap = makeBridgeMap(bridgeToNow, bridge, nowMove)
        outputView.printMap(playMap)
        return bridge[bridgeToNow-1] == nowMove
    }

    private fun makeBridgeMap(bridgeToNow: Int, bridge: List<String>, nowMove: String): Pair<List<String>, List<String>> {
        val bridgeTopMap = mutableListOf<String>()
        val bridgeDownMap = mutableListOf<String>()
        for (i in 0 until bridgeToNow) {
            bridgeTopMap.add(addBridgeTopMap(bridgeToNow, bridge[i], i, nowMove))
            bridgeDownMap.add(addBridgeDownMap(bridgeToNow, bridge[i], i, nowMove))
            if (i != bridgeToNow-1) {
                bridgeTopMap.add("|")
                bridgeDownMap.add("|")
            }
        }
        return Pair(bridgeTopMap, bridgeDownMap)
    }

    private fun addBridgeTopMap(bridgeToNow: Int, bridge: String, idx: Int, nowMove: String): String {
        if (bridgeToNow - 1 == idx && bridge != nowMove) {
            if (bridge == "U") return " "
            if (bridge == "D") return "X"
        }
        if (bridge == "U") return "O"
        if (bridge == "D") return " "
        throw IllegalArgumentException("$MESSAGE_ERROR 잘못된 입력 값입니다.")
    }

    private fun addBridgeDownMap(bridgeToNow: Int, bridge: String, idx: Int, nowMove: String): String {
        if (bridgeToNow - 1 == idx && bridge != nowMove) {
            if (bridge == "U") return "X"
            if (bridge == "D") return " "
        }
        if (bridge == "U") return " "
        if (bridge == "D") return "O"
        throw IllegalArgumentException("$MESSAGE_ERROR 잘못된 입력 값입니다.")
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun retry(bridgeSize: Int, bridgeMaker: List<String>, numberOfGames:Int) {
        val retry = outputView.printRetry()
        if (retry == "R") return play(bridgeSize,bridgeMaker, numberOfGames+1)
        if(retry == "Q"){
            outputView.printResult(MESSAGE_FAILLED, numberOfGames)
        }
    }

    private fun result(numberOfGames:Int){
        println(MESSAGE_RESULT_MAP)
        outputView.printMap(playMap)
        outputView.printResult(MESSAGE_SUCCESS, numberOfGames)
    }
}
