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
    fun printMap(userInput:List<String>, bridge: List<String>) {
        print("[")
        printUpMap(userInput,bridge)
        println("]")
        print("[")
        printDownMap(userInput,bridge)
        println("]")

    }

    private fun printUpMap(userInput: List<String>, bridge: List<String>){
        var crossCount = userInput.size
        for(i in userInput.indices){
            crossCount--
            checkSameWithBridgeUpCase(userInput[i], bridge[i])
            if(crossCount!=0){
                print("|")
            }
        }
    }

    private fun checkSameWithBridgeUpCase(userInput:String, bridge: String){
        if(userInput == "U" && bridge=="U"){
            print(" O ")
        }
        else if(userInput=="U" && bridge =="D"){
            print(" X ")
        }
        else {
            print("   ")
        }
    }

    private fun checkSameWithBridgeDownCase(userInput:String, bridge: String){
        if(userInput == "D" && bridge=="D"){
            print(" O ")
        }
        else if(userInput=="D" && bridge =="U"){
            print(" X ")
        }
        else {
            print("   ")
        }
    }
    private fun printDownMap(userInput: List<String>, bridge: List<String>){
        var crossCount = userInput.size
        for(i in userInput.indices){
            crossCount--
            checkSameWithBridgeDownCase(userInput[i], bridge[i])
            if(crossCount!=0){
                print("|")
            }
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(userInput: List<String>, bridge: List<String>, tryCount:Int) {
        println("최종 게임 결과")
        printMap(userInput, bridge)
        print("게임 성공 여부: ")
        val res = checkResult(userInput,bridge)
        print(if(res) "성공" else "실패")
        println("총 시도한 횟수: $tryCount")
    }

    private fun checkResult(userInput: List<String>, bridge: List<String>):Boolean{
        if(userInput.size == bridge.size){
            return checkAllElementSame(userInput,bridge)
        }
        return false
    }

    private fun checkAllElementSame(userInput: List<String>, bridge: List<String>):Boolean{
        for(i in userInput.indices){
            if(userInput[i]!= bridge[i]) return false
        }
        return true
    }

    fun printOpeningMessage(){
        println("다리 게임을 시작합니다")
    }
}
