package bridge.model

import bridge.MovingEventManager
import bridge.QuitEventManager

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val _movingEventManager: MovingEventManager, private val _quitEventManager: QuitEventManager) {
    private lateinit var _bridge: List<String>
    private var _userHistory = mutableListOf<String>()
    private var _attempts: Int = 1

    fun start(bridge: List<String>) {
        require(!started()) { "게임은 한 번만 시작할 수 있습니다." }
        validateBridge(bridge)
        this._bridge = bridge
    }

    private fun validateBridge(bridge: List<String>) =
        require(bridge.size in 3..20 && bridge.all { it == "U" || it == "D" }) { "다리의 길이는 3 이상 20 이하여야 하고 U 또는 D만 포함할 수 있습니다." }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(moving: String) {
        check(running()) { "게임이 실행되었을 때만 움직일 수 있습니다." }
        _userHistory += moving
        _movingEventManager.notify(GameMapStatus(_bridge, _userHistory))
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        check(stopped()) { "게임이 중지 상태일 때만 재시작할 수 있습니다." }
        _userHistory.clear()
        _attempts++
    }

    fun quit() {
        check(started()) { "게임이 시작된 상태여야 종료할 수 있습니다." }
        _quitEventManager.notify(GameMapStatus(_bridge, _userHistory), GameResult(succeeded(), _attempts))
    }

    private fun started(): Boolean = ::_bridge.isInitialized

    private fun running(): Boolean = started() && !succeeded() && !failed()

    private fun stopped(): Boolean = started() && (succeeded() || failed())

    fun failed(): Boolean {
        check(started()) { "게임이 시작되어야 실패했는지 판단할 수 있습니다." }
        return _userHistory.isNotEmpty() && _userHistory.last() != _bridge[_userHistory.size - 1]
    }

    fun succeeded(): Boolean {
        check(started()) { "게임이 시작되어야 성공했는지 판단할 수 있습니다." }
        return _bridge.size == _userHistory.size && (_bridge.indices).all { _bridge[it] == _userHistory[it] }
    }
}
