package bridge

import bridge.BridgeGameStarter.Companion.cnt
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

    fun printResult() {
        if(success == "True") printIfTrue()
        if(success == "False") printIfFalse()
    }

    fun printIfTrue(){
        println("최종 게임 결과")
        println(movingUpside.joinToString(" | ", "[ ", " ]"))
        println(movingDownside.joinToString(" | ", "[ ", " ]"))
        println("\n게임 성공 여부: 성공\n총 시도한 횟수: ${cnt}")
    }

    fun printIfFalse(){
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        var command = InputView().readGameCommand()

        commandResult(command)
    }

    fun commandResult(cmd: String){
        if(cmd == "R") BridgeGame().retry()
        else if(cmd == "Q") {
            println("최종 게임 결과")
            println(movingUpside.joinToString(" | ", "[ ", " ]"))
            println(movingDownside.joinToString(" | ", "[ ", " ]"))
            println("\n게임 성공 여부: 실패\n총 시도한 횟수: ${cnt}")
            OutputView().printResult()
        }
    }

}