package bridge.view

import bridge.Strings
import bridge.exception.PrintException
import kotlin.text.StringBuilder

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    val sbUp = StringBuilder()
    val sbDown = StringBuilder()
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridge : List<String>) {

        for (i in 0 until bridge.size){
            var direction = PrintException().printDirection()
            printUp(bridge,direction, i)
            printDown(bridge,direction ,i)
        }

    }

    fun printUp(bridge : List<String> ,direction : String , i : Int ){

            if (i>0) { sbUp.append("|") }
            if (direction=="U" && direction==bridge[i]) { sbUp.append(" O ") }
            if (direction=="U" && direction!=bridge[i]) { sbUp.append(" X ") }
            if (direction=="D") { sbUp.append("   ") }

        println("[" + sbUp + "]")
    }


    fun printDown(bridge : List<String> ,direction : String, i : Int ){

        if (i>0) { sbDown.append("|") }
        if (direction=="D" && direction==bridge[i]) { sbDown.append(" O ") }
        if (direction=="D" && direction!=bridge[i]) { sbDown.append(" X ") }
        if (direction=="U") { sbDown.append("   ") }

        println("[" + sbDown + "]")
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(upBridge : StringBuilder , downBridge : StringBuilder){
        println(Strings.GAME_RESULT.phrases)
        println("[ " + upBridge + " ] ")
        println("[ " + downBridge + " ] ")

    }

    fun failGame(){
        println("${Strings.GAME_SUCCESS_OR_NOT}"+ "실패")

    }
}
