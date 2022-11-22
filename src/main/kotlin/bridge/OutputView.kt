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
    fun printMap(bridge : List<String>, location : Int, moveCommand : String) {
        println(printUp(bridge,location,moveCommand))
        println(printDown(bridge,location,moveCommand))
    }

    private fun printDown(bridge: List<String>, location: Int, moveCommand: String): String {
        var print = "[ "
        for(i: Int in 0..location-1){
            print += checkDown(bridge,i)
            print +=" | "
        }
        if(moveCommand == "D") print += checkCanGoDown(bridge, location, moveCommand)
        else print += "  ]"
        return print
    }

    private fun checkCanGoDown(bridge: List<String>, location: Int, moveCommand: String): String {
        return if(bridge[location] == moveCommand)
            "O ]"
        else
            "X ]"
    }

    private fun checkDown(bridge: List<String>, i: Int): String {
        return if(bridge[i] == "D")
            "O"
        else
            " "
    }


    private fun printUp(bridge: List<String>, location: Int, moveCommand : String) : String {
        var print = "[ "
        for(i: Int in 0..location-1){
           print += checkUp(bridge,i)
           print +=" | "
        }
        if(moveCommand == "U") print += checkCanGoUp(bridge, location, moveCommand)
        else print += "  ]"
        return print
    }
    private fun checkCanGoUp(bridge: List<String>, location : Int, moveCommand : String): String {
        return if(bridge[location] == moveCommand)
            "O ]"
        else
            "X ]"
    }

    private fun checkUp(bridge: List<String>, i: Int) : String {
        return if(bridge[i] == "U")
            "O"
        else
            " "
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(successOrNot : Boolean, count : Int) {
        if(successOrNot){
            println("게임 성공 여부: 성공")
        }else{
            println("게임 성공 여부: 실패")
        }
        println("총 시도한 횟수: $count")
    }
}
