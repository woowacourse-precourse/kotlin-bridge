package bridge

import view.InputView

/**
 * 다리 건너기 게임을 관리하는 클래스
BridgeGame에 필드를 추가할 수 있다.
BridgeGame의 패키지는 변경할 수 있다.
BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
게임 진행을 위해 필요한 메서드를 추가하거나 변경 할 수 있다.
BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 */
class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(bridgeSize: Int, moveLetter: String): List<String>{
        val bridgeLetter = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        val result: MutableList<String> = mutableListOf()
        for(i in 0 until bridgeSize){
            if(bridgeLetter[i] != moveLetter){
                result[i] = "X"
                return result
            }
            result[i] = "O"
        }
        return result
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(gameCommend: String): Boolean {
        return gameCommend == "R"
    }
}
