package bridge

class PrintForm {
    fun printGameStartText() {
        println("다리 건너기 게임을 시작합니다.")
    }

    fun printPleaseInputBridgeLength() {
        println("다리의 길이를 입력해주세요.")
    }

    fun printUserInputError() {
        println("[ERROR] 입력값에 오류가 있습니다. 다시 입력해주세요.")
    }

    fun printUserMovementForm() {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
    }

    fun printListToString(list : MutableList<String>) {
        println("[ ${list.joinToString().replace(",", " |")} ]")
    }

    fun printWannaRetry() {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    }
}