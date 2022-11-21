package bridge

fun main() {
    val list = listOf("U", "D", "U")

    val a = mutableListOf<String>()
    val b = mutableListOf<String>()
    println("다리 건너기 게임을 시작합니다.\n")
    println("다리길이 입력하셈")
    val read = readLine()!!.toInt()

    for (i in 0 until read) {
        println("어디로 가실")
        val readUp = readLine()
        if (list[i] == readUp) {
            if (readUp == "U") {
                a.add(" O ")
                b.add("   ")
            }

            if (readUp == "D") {
                a.add("   ")
                b.add(" O ")
            }
        } else {
            if (readUp == "U") {
                a.add(" X ")
                b.add("   ")
            }

            if (readUp == "D") {
                a.add("   ")
                b.add(" X ")
            }
            println(a.joinToString(prefix = "[", separator = "|", postfix = "]"))
            println(b.joinToString(prefix = "[", separator = "|", postfix = "]"))

            break
        }
        println(a.joinToString(prefix = "[", separator = "|", postfix = "]"))
        println(b.joinToString(prefix = "[", separator = "|", postfix = "]"))
    }

    println("끗")
}
