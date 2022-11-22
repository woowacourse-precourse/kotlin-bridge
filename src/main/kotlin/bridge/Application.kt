package bridge

fun main() {
    // TODO: 프로그램 구현
}
fun showResult(moves: List<String>, answers: List<String>, attempt:Int) : Boolean{
    OutputView().printMap(moves,answers)
    if(moves[attempt] != answers[attempt]){ //정답이 아닌 경우
        return true
    }
    return false
}