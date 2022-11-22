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

    fun addRightU(bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>):Pair<MutableList<String>,MutableList<String>>{
        bridgePrintU.add(" O ")
        bridgePrintD.add("   ")
        return Pair(bridgePrintU,bridgePrintD)
    }

    fun addRightD(bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>):Pair<MutableList<String>,MutableList<String>>{
        bridgePrintU.add("   ")
        bridgePrintD.add(" O ")
        return Pair(bridgePrintU,bridgePrintD)
    }
    fun addStick(bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>):Pair<MutableList<String>,MutableList<String>>{
        bridgePrintU.add("|")
        bridgePrintD.add("|")
        return Pair(bridgePrintU,bridgePrintD)
    }

    fun chooseUD(bridgeI:String, bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>){
        if(bridgeI == "U"){
            var(bridgePrintU,bridgePrintD) = addRightU (bridgePrintU,bridgePrintD)
        } else{
            var(bridgePrintU,bridgePrintD) = addRightD (bridgePrintU,bridgePrintD)
        }
    }

    fun printMap(bridge : List<String>,number : Int) {
        var bridgePrintU = mutableListOf<String>("[")
        var bridgePrintD = mutableListOf<String>("[")
        for(i in 0 .. number){
            chooseUD(bridge[i],bridgePrintU,bridgePrintD)
            if(i == number) break
            var(bridgePrintU,bridgePrintD) = addStick (bridgePrintU,bridgePrintD)
        }
        stringPrint(bridgePrintU,bridgePrintD)
    }

    fun addRightUF(bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>):Pair<MutableList<String>,MutableList<String>>{
        bridgePrintU.add(" O |")
        bridgePrintD.add("   |")
        return Pair(bridgePrintU,bridgePrintD)
    }

    fun addRightDF(bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>):Pair<MutableList<String>,MutableList<String>>{
        bridgePrintU.add("   |")
        bridgePrintD.add(" O |")
        return Pair(bridgePrintU,bridgePrintD)
    }

    fun falseD(bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>):Pair<MutableList<String>,MutableList<String>>{
        bridgePrintU.add("   ")
        bridgePrintD.add(" X ")
        return Pair(bridgePrintU,bridgePrintD)
    }

    fun falseU(bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>):Pair<MutableList<String>,MutableList<String>>{
        bridgePrintU.add(" X ")
        bridgePrintD.add("   ")
        return Pair(bridgePrintU,bridgePrintD)
    }

    fun chooseUDF(bridgeI:String, bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>){
        if(bridgeI == "U"){
            var(bridgePrintU,bridgePrintD) = addRightUF(bridgePrintU,bridgePrintD)
        } else{
            var(bridgePrintU,bridgePrintD) = addRightDF(bridgePrintU,bridgePrintD)
        }
    }

    fun chooseUDFLast(bridgeI:String, bridgePrintU: MutableList<String>, bridgePrintD: MutableList<String>){
        if(bridgeI == "U"){
            var(bridgePrintU,bridgePrintD) = falseD(bridgePrintU,bridgePrintD)
        } else{
            var(bridgePrintU,bridgePrintD) = falseU(bridgePrintU,bridgePrintD)
        }
    }


    fun printMapFalse(bridge : List<String>,number : Int) {
        var bridgePrintU = mutableListOf<String>("[")
        var bridgePrintD = mutableListOf<String>("[")
            for(i in 0 .. (number-1)){
               chooseUDF(bridge[i],bridgePrintU,bridgePrintD)
            }
            chooseUDFLast(bridge[number-1],bridgePrintU,bridgePrintD)
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
