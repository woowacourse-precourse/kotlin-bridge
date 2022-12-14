package bridge

import bridge.Constant.ANSWER
import bridge.Constant.DOWN
import bridge.Constant.EMPTY
import bridge.Constant.ERROR_MESSAGE
import bridge.Constant.FALL
import bridge.Constant.UP

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge : List<String>) : BridgeGameGenerator{

    private var _upBridge: MutableList<String> = mutableListOf<String>()
    val upBridge get() = _upBridge
    private var _downBridge: MutableList<String> = mutableListOf<String>()
    val downBridge get() = _downBridge
    private var _isSuccess : Boolean = true
    val isSuccess get() = _isSuccess
    private var _totalCount: Int = 1
    val totalCount get()  = _totalCount
    private var count: Int = 0


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    override fun move(moveOrder: String) {
        when (bridge[count]) {
            UP -> upMove(moveOrder == UP)
            DOWN -> downMove(moveOrder == DOWN)
        }
        count++
    }

    override fun upMove(isCorrect: Boolean) {
        _isSuccess = if (isCorrect) {
            _upBridge.add(ANSWER)
            _downBridge.add(EMPTY)
            true
        } else {
            _upBridge.add(EMPTY)
            _downBridge.add(FALL)
            false
        }
    }

    override fun downMove(isCorrect: Boolean) {
        _isSuccess = if (isCorrect) {
            _upBridge.add(EMPTY)
            _downBridge.add(ANSWER)
            true
        } else {
            _upBridge.add(FALL)
            _downBridge.add(EMPTY)
            false
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    override fun retry() {
        _upBridge = mutableListOf<String>()
        _downBridge = mutableListOf<String>()
        this.count = 0
        _totalCount++
        _isSuccess = true
    }

    override fun isGameEnd(): Boolean {
        if (!_isSuccess) return true
        if (count == bridge.size) return true
        return false
    }
}
