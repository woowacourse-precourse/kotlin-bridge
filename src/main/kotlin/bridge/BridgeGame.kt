package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    // TODO 필드가 너무 많아질 것 같은데 리팩터 할 때 잘 나누기
    private val output = OutputView()
    private val input = InputView()
    private var tryingCount = 0
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun start() {
        // 시작 메세지

        // 다리 길이 출력, 입력 -> 클래스 필드에 length 저장 (맵은 재활용이니까)
        // 다리 길이를 갖고 맵 만들기 -> bridgeMaker 사용 -> 필드에 저장 (bridgeMaker는 만드는 작업만)
    }

    fun move() {
        // 이동할 칸 메세지 출력
        // 이동할 칸 입력 및 옳바른 값인지 체크
        // 맵과 비교해 이동할 수 있는지 없는지 체크
        // 맵을 출력
        // 이동 여부를 리턴
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}

    fun gameOver() {
        // 최종 게임 결과를 알려준다.
    }
}
