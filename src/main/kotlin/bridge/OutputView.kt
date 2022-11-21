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
    fun printMap(bridge: List<String>, result: String, step: Int){
        for ( i in 0..step-1 ) {
            if ( i == 0 ) print("[")
            if ( bridge[i] == "U" ) print(" O ")
            else print("   ")
            print("|")
        }
        printMapLast(bridge, result, step)
    }
    fun printMapLast(bridge: List<String>, result: String, step: Int): Boolean {
        if ( bridge[step] == "U") {
            if (result == "U") print(" O ]")
            else print(" X ]")
        } else {
            print("   ]")
            printMapBottom(bridge, result, step)
        }
        return if ( bridge[step] == result ) true else false
    }
    fun printMapBottom(bridge: List<String>, result: String, step: Int) {
        for ( i in 0..step-1 ){
            if ( i == 0 ) print("\n[")
            if ( bridge[i] == "D" ) print(" O ")
            else print("   ")
            print("|")
        }
        printMapBottomLast(bridge, result, step)
    }

    fun printMapBottomLast(bridge: List<String>, result: String, step: Int): Boolean {
        if ( bridge[step] == "D") {
            if (result == "D") print(" O ]")
            else print(" X ]")
        } else print("   ]")
        return if ( bridge[step] == result ) true else false
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
