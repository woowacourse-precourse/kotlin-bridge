package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(userChoice : MutableList<String>, check : Boolean) : MutableList<String>{

        var printMap = mutableListOf<String>()
        printMap.add(plusMap(userChoice, check, "U"))
        printMap.add(plusMap(userChoice, check, "D"))
        for(i in 0 until printMap.size){
            println(printMap[i])
        }
        return printMap
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
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
