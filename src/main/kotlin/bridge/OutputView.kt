package bridge
class OutputView {
    fun firstlineprint(a: List<String>, b: Int) {
        var i = 0
        print("[ ")
        do {
            upcheckprint(a[i])
            if (i == b - 1) {
                println(" ]")
                break
            }
            print(" | ")
            i++
        } while (i < 20)
    }

    fun secondlineprint(a: List<String>, b: Int) {
        var j = 0
        print("[ ")
        do {
            Downcheckprint(a[j])
            if (j == b - 1) {
                println(" ]")
                break
            }
            print(" | ")
            j++
        } while (j < 20)
    }

    fun printMap(a: List<String>, b: Int) {
        firstlineprint(a, b)
        secondlineprint(a, b)
    }

    fun printResult(a: List<String>, b: Int) {
        firstlineprint(a, b)
        secondlineprint(a, b)
    }

    fun upcheckprint(a: String) {
        if (a == "U") {
            print("O")
        }
        if (a == "D") {
            print(" ")
        }
    }

    fun Downcheckprint(a: String) {
        if (a == "U") {
            print(" ")
        }
        if (a == "D") {
            print("O")
        }
    }
}
