package bridge

import bridge.BridgeGameStarter.Companion.success
import bridge.SketchBridge.Companion.movingDownside
import bridge.SketchBridge.Companion.movingUpside

class OutputView {

    fun printStart(){
        println("다리 건너기 게임을 시작합니다.")
        println()
        println("다리의 길이를 입력해주세요.")
    }

    fun printSelection(){
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    fun printMap(moving: List<String>) {
        SketchBridge().upBridge(moving)
        SketchBridge().downBridge(moving)

        println(movingUpside.joinToString(" | ", "[ ", " ]"))
        println(movingDownside.joinToString(" | ", "[ ", " ]"))
        println()

        if(moving.last() == "UF" || moving.last() == "DF") success = "False"
    }

    fun printResult() {}
}