package bridge

import util.Messages
import java.lang.StringBuilder

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printMap(userChoice : MutableList<String>, check : Boolean) : MutableList<String>{
        var printMap = mutableListOf<String>()
        printMap.add(plusMap(userChoice, check, "U"))
        printMap.add(plusMap(userChoice, check, "D"))
        for(i in 0 until printMap.size){
            println(printMap[i])
        }
        return printMap
    }

    fun printResult(result : MutableList<String>, flag : Boolean, cnt : Int) {
        println()
        println(Messages.RESULT)
        println(result[0])
        println(result[1])
        println()
        println(Messages.CLEAR + checkSuccess(flag))
        println(Messages.TRY_COUNT + "$cnt")
    }

    private fun plusMap(userChoice: MutableList<String>, check: Boolean, command : String) : String{
        var sb = StringBuilder()
        sb.append("[")
        for(i in 0 until userChoice.size - 1){
            if(userChoice[i] == command){
                sb.append(" O |")
                continue
            }
            sb.append("   |")
        }
        if(userChoice[userChoice.size - 1] == command){
            if(check){
                sb.append(" O ]")
                return sb.toString()
            }
            sb.append(" X ]")
            return sb.toString()
        }
        sb.append("   ]")
        return sb.toString()
    }

    private fun checkSuccess(flag: Boolean) : String{
        if(flag){
            return Messages.SUCCESS
        }
        return Messages.FAIL
    }
}
