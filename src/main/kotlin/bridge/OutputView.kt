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
    fun printMapFirst(bridge: List<String>, direction: String, step: Int){
        println(bridge[step] + direction)
        if ( bridge[step] == "U") {
            if (direction == "U") print("[ O ]")
            else print("[ X ]")
        } else { print("[   ]")}
        if ( bridge[step] == "D") {
            if (direction == "D") print("\n[ O ]")
            else print("\n[ X ]")
        } else print("\n[   ]\n")
    }

    fun printMap(bridge: List<String>, direction: String, step: Int){
        for ( i in 0..step-1 ) {
            if ( i == 0 ) print("[")
            if ( bridge[i] == "U" ) print(" O ")
            else print("   ")
            print("|")
        }
        printMapLast(bridge, direction, step)
    }
    fun printMapLast(bridge: List<String>, direction: String, step: Int){
        if ( bridge[step] == "U") {
            if (direction == "U") print(" O ]")
            else print("   ]")
        } else {
            if (direction == "U") print(" X ]")
            else print("   ]")
        }
        printMapBottom(bridge, direction, step)
    }
    fun printMapBottom(bridge: List<String>, direction: String, step: Int) {
        for ( i in 0..step-1 ){
            if ( i == 0 ) print("\n[")
            if ( bridge[i] == "D" ) print(" O ")
            else print("   ")
            print("|")
        }
        printMapBottomLast(bridge, direction, step)
    }

    fun printMapBottomLast(bridge: List<String>, direction: String, step: Int){
        if ( bridge[step] == "D") {
            if (direction == "D") print(" O ]")
            else print("   ]")
        } else {
            if (direction == "D") print(" X ]")
            else print("   ]")
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridge: List<String>, bridgeSize: Int) {
        printResultLine(bridge, bridgeSize, "U")
        println()
        printResultLine(bridge, bridgeSize, "D")
    }

    fun printResultQuit(bridge: List<String>, step: Int){
        printResultLine(bridge, step, "U")
        println()
        printResultLine(bridge, step, "D")
    }

    fun printResultLine(bridge: List<String>, bridgeSize: Int, correctDirection: String ){
        print("[")
        for ( i in 0..bridgeSize - 1){
            if ( bridge[i] == correctDirection ) print(" O |") else print("   |")
        }
        if ( bridge[bridgeSize] == correctDirection ) print("   ]") else print(" X ]")
    }


}
