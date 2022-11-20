package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * 요구사항 ⬇
 * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
class OutputView {

    fun printGameStart() {
        println(GAME_START)
        println()
    }

    fun printRequestInputBridgeSize() {
        println(REQUEST_INPUT_BRIDGE_SIZE)
    }

    fun printRequestInputDirectionToMove() {
        println(REQUEST_INPUT_DIRECTION_TO_MOVE)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(upBridge: Bridge, downBridge: Bridge) {
        println(upBridge.toString())
        println(downBridge.toString())
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    companion object {
        const val GAME_START = "다리 건너기 게임을 시작합니다."
        const val REQUEST_INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
        const val REQUEST_INPUT_DIRECTION_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    }
}
