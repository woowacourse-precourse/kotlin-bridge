package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(direction: String): Int {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)\n")

        return direction.decideNextPosition()
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(retryFlag: String): Boolean {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n")

        return retryFlag.decideRetryOrQuit()
    }

    fun String.decideNextPosition() = if (this == "U") {
        0
    } else {
        1
    }

    fun String.decideRetryOrQuit() = this == "R"
}
