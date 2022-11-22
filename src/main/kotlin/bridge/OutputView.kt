package bridge



/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     */
    fun printMap(case:List<String>) {
        print("[")
        for (i: Int in 0 until case.size)
            printFirstMap(case[i],i,case.size)
        println("]")
        print("[")
        for (i: Int in 0 until case.size)
            printSecondMap(case[i],i,case.size)
        println("]")
    }

    // 위쪽 줄 출력
    private fun printFirstMap(case:String, count : Int, size:Int){
        if(count != size && count != 0)
            print("|")
        if(case == "A")
            print(" O ")
        else if(case == "B")
            print("   ")
        else if(case == "C")
            print(" X ")
        else if(case == "D")
            print("   ")
    }

    // 아래쪽 줄 출력
    private fun printSecondMap(case:String, count : Int, size:Int){
        if(count != size && count != 0)
            print("|")
        if(case == "A")
            print("   ")
        else if(case == "B")
            print(" O ")
        else if(case == "C")
            print("   ")
        else if(case == "D")
            print(" X ")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(case: MutableList<String>,success:String,count:Int) {
        println()
        println("최종 게임 결과")
        printMap(case)
        println()
        println("게임 성공 여부: $success")
        print("총 시도한 횟수: $count")
    }
}
