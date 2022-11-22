package bridge

/*** 사용자에게게임진행상황과결과를출력하는역할을한다.*/
class OutputView {

    /*** 현재까지이동한다리의상태를정해진형식에맞춰출력한다.
    출력을위해필요한메서드의인자(parameter)는자유롭게추가하거나변경할수있다.*/
    fun printMap(map : String){
        println("["+map+"]")
    }
    /*** 게임의최종결과를정해진형식에맞춰출력한다.
    출력을위해필요한메서드의인자(parameter)는자유롭게추가하거나변경할수있다.*/
    fun printResult() {
        println("최종 게임 결과")
    }

    fun printResult1(message : String, cnt : Int) {
        println("게임 성공 여부: "+message)
        println("총 시도한 횟수: "+cnt)
    }

    fun printStartGame() {
        println("다리 건너기 게임을 시작합니다.\n")
    }

    fun inputBridgeLength() {
        println("다리의 길이를 입력해주세요.")
    }

    fun chooseMove() {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    fun askRegameOrQuit() {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    }
}