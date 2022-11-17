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
    fun firstlineprint(a: List<String>, b: Int) {
        var i = 0
        print("[ ")
        do{
            upcheckprint(a[i])
            if (i == b-1) {
                println(" ]")
                break }
            print(" | ")
            i++ } while(i < 20)
    }

    fun secondlineprint(a: List<String>, b: Int){
        var j = 0
        print("[ ")
        do{
            Downcheckprint(a[j])
            if (j == b-1) {
                println(" ]")
                break }
            print(" | ")
            j++ } while(j < 20)
    }
    fun printMap(a: List<String> , b:Int) {
        firstlineprint(a,b)
        secondlineprint(a,b)
    }

    fun resultfirstlineprint(a: List<String>, b: Int) {
        var i = 0
        print("[ ")
        do{
            resultupcheckprint(a[i])
            if (i == b-1) {
                println(" ]")
                break }
            print(" | ")
            i++ } while(i < 20)
    }
    fun resultsecondlineprint(a: List<String>, b: Int){
        var j = 0
        print("[ ")
        do{
            resultDowncheckprint(a[j])
            if (j == b-1) {
                println(" ]")
                break
            }
            print(" | ")
            j++
        }while(j < 20)
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(a: List<String>, b:Int) {
        resultfirstlineprint(a,b)
        resultsecondlineprint(a,b)
    }

    fun upcheckprint (a: String ) {
        if (a == "U") {
            print("O")
        }
        if (a == "D") {
            print(" ")
        }
    }
    fun Downcheckprint (a: String ) {
        if (a == "U") {
            print(" ")
        }
        if (a == "D") {
            print("O")
        }
    }
    fun resultupcheckprint (a: String ) {
        if (a == "U") {
            print("O")
        }
        if (a == "D") {
            print("X")
        }
    }
    fun resultDowncheckprint (a: String ) {
        if (a == "U") {
            print("X")
        }
        if (a == "D") {
            print("O")
        }
    }


}
