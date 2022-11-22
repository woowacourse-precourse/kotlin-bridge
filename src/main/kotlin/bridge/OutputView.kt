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


    fun printMap(bridge : List<String>,number : Int) {
        var bridgePrintU = mutableListOf<String>("[")
        var bridgePrintD = mutableListOf<String>("[")
        for(i in 0 .. number){
            if(bridge[i] == "U"){
                bridgePrintU.add(" O ")
                bridgePrintD.add("   ")
            } else{
                bridgePrintU.add("   ")
                bridgePrintD.add(" O ")
            }
            if(i == number) break
            bridgePrintD.add("|")
            bridgePrintU.add("|")
        }
        stringPrint(bridgePrintU,bridgePrintD)
    }

    fun printMapFalse(bridge : List<String>,number : Int) {
        var bridgePrintU = mutableListOf<String>("[")
        var bridgePrintD = mutableListOf<String>("[")
            for(i in 0 .. (number-1)){
                if(bridge[i] == "U"){
                    bridgePrintU.add(" O |")
                    bridgePrintD.add("   |")
                } else{
                    bridgePrintU.add("   |")
                    bridgePrintD.add(" O |")
                }
            }
            if(bridge[number-1] == "U"){
                bridgePrintU.add("   ")
                bridgePrintD.add(" X ")
            } else{
                bridgePrintU.add(" X ")
                bridgePrintD.add("   ")
            }

        stringPrint(bridgePrintU,bridgePrintD)
        }

    fun stringPrint(bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>){
        bridgePrintU.add("]")
        bridgePrintD.add("]")
        var bridgeUS = bridgePrintU.joinToString("")
        var bridgeDS = bridgePrintD.joinToString("")
        println(bridgeUS)
        println(bridgeDS)
    }



    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridge: List<String>, size:Int,count : Int) {
        var outputView = OutputView()
        println("최종 게임 결과")
        outputView.printMap(bridge,size)
        println("게임 성공 여부: 성공")
        println("총 시도한 횟수: ${count}")
    }

    fun printResultFail(bridge: List<String>, size:Int,count : Int){
        var outputView = OutputView()
        println("최종 게임 결과")
        outputView.printMapFalse(bridge,size)
        println("게임 성공 여부: 실패")
        println("총 시도한 횟수: ${count}")
    }
}
