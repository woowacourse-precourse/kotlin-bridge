package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printBridge() {
        println("다리의 길이를 입력해주세요.")
    }

    fun printMove() {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(triple: Triple<Int, MutableList<String>, MutableList<String>>) {
        val (position, upBridge, downBridge) = triple
        println("[ ${upBridge.slice(0..position).joinToString(" | ")} ]")
        println("[ ${downBridge.slice(0..position).joinToString(" | ")} ]")
    }

    fun printRetry() {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(triple: Triple<Int, MutableList<String>, MutableList<String>>, isSuccess: Boolean) {
        println("최종 게임 결과")
        this.printMap(triple)
        when (isSuccess) {
            true -> println("게임 성공 여부: 성공")
            false -> println("게임 성공 여부: 실패")
        }
    }

    fun printTryNumber(tryCounter: Int) {
        println("총 시도한 횟수: $tryCounter")
    }
}
