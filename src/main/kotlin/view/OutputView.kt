package view

class OutputView {
    fun printMap(sides: List<String>) {
        println(sides[0])
        println(sides[1])
    }

    fun printResult(sides: List<String>, result: String, retryCount: Int) {
        println("최종 게임 결과")
        printMap(sides)
        println(
            "게임 성공 여부: $result\n" +
                    "총 시도한 횟수: $retryCount"
        )
    }

    fun printStart() {
        println("다리 건너기 게임을 시작합니다.")
        println("\n다리의 길이를 입력해주세요.")
    }

    fun printMove() {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    fun printRestart() {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    }
}
