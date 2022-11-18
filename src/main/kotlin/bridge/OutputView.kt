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
    fun printMap(bridge : List<String>, userRoute : MutableList<String>, move : String) : Int {
        var control  = 0
        for (i in 0 until userRoute.size){
            printStartMap(i)
            if (userRoute[i] == bridge[i]) { printCorrectMap(userRoute, i, move) }
            if (userRoute[i] != bridge[i]) { control = printWrongMap(userRoute, i, move) }
            printConnectMap(userRoute, i)
        }
        return control
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridge: List<String>, userRoute: MutableList<String>, upDown: List<String>) {
        //최종게임결과//
        println("최종 게임 결과")
        for (move in upDown){
            for (i in 0 until userRoute.size){
                printStartMap(i)
                if (userRoute[i] == bridge[i]) { printCorrectMap(userRoute, i, move) }
                if (userRoute[i] != bridge[i]) { printWrongMap(userRoute, i, move) }
                printConnectMap(userRoute, i)
            }
        }
    }

    fun printCorrectMap(userRoute: MutableList<String>, i : Int, move : String){
        if (userRoute[i] == move) {
            print(" O ")
        }
        if (userRoute[i] != move) {
            print("   ")
        }
    }

    fun printWrongMap(userRoute: MutableList<String>, i: Int, move: String) : Int{
        if (userRoute[i] == move){
            print(" X ")
            return 1
        }
        if (userRoute[i] != move){
            print("   ")
        }
        return  0
    }

    fun printStartMap(i: Int){
        if (i == 0){
            print("[")
        }
    }

    fun printConnectMap(userRoute: MutableList<String>, i: Int){
        if (i != userRoute.size - 1) {
            print("|")
        }
        if (i == userRoute.size - 1) {
            println("]")
        }
    }

    fun printGameSituation(control : Int, times : Int){
        if (control == 1) {
            println("게임 성공 여부: 실패")
        }
        if (control == 0) {
            println("게임 성공 여부: 성공")
        }
        println("총 시도한 횟수: $times")
    }
}
