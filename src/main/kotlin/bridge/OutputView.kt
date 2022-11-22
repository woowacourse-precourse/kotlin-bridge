package bridge

class OutputView {

    fun printStart(){
        println("다리 건너기 게임을 시작합니다.")
        println()
        println("다리의 길이를 입력해주세요.")
    }

    fun printSelection(){
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    fun printMap() {}

    fun printResult() {}
}