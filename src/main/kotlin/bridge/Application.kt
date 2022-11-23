package bridge

fun main() {
    // 게임 실행
    playSquidGame()
}
// 게임을 진행하는 함수
fun playSquidGame(){
    // 시작 멘트
    OutputView().printGameStart()
    // 다리 size 입력
    val bridgeSize = InputView().readBridgeSize()
    // interface: 다형성 ->유지보수의 편의를 위해 사용(공부!)
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    // 랜덤 값 저장
    val bridge=bridgeMaker.makeBridge(bridgeSize)
    // 방향 입력 및 정답 비교, 재도전
    BridgeGame(bridge).tryMove()
}