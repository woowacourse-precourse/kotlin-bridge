package bridge.view

import bridge.BridgeGame
import bridge.Strings
import bridge.exception.PrintException
import kotlin.text.StringBuilder

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridge : BridgeGame) {
        val sbUp = StringBuilder()
        sbUp.append("[ ").append(bridge.upBridge.joinToString(" | ")).append(" ]")
        val sbDown = StringBuilder()
        sbDown.append("[ ").append(bridge.downBridge.joinToString(" | ")).append(" ]")

        println(sbUp)
        println(sbDown)
    }



    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridge : BridgeGame){
        println(Strings.GAME_RESULT.phrases)
        printMap(bridge)

        print(Strings.GAME_SUCCESS_OR_NOT.phrases)
        if (bridge.choiceAll() && bridge.choiceSame()){ println(Strings.SUCCESS.phrases) }
        if (!bridge.choiceAll() || !bridge.choiceSame()){ println(Strings.FAIL.phrases) }

        println("\n" + Strings.GAME_TRY_COUNT.phrases + bridge.count)


    }


}
