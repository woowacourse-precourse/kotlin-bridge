package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge : List<String>) {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private var retryCount = 1
    fun move() {
        val mBridge = bridge.toMutableList() //통과할 때 마다 앞에서 하나씩 삭제하면서 비교하기 위함이다. 다만 재도전할 시 원본 목록이 필요하므로, 재생성했다.
        val upperList = mutableListOf<String>()
        val downList = mutableListOf<String>()

        loopToCheckBridge(mBridge, upperList, downList)
    }

    private fun loopToCheckBridge(mBridge : MutableList<String>, upperList : MutableList<String>, downList: MutableList<String>) {
        while(mBridge.size != 0) {
            val userMoveInput = UserInput().userInputMovement()
            if(!Compare(upperList, downList).checkIsSuccessOrFail(userMoveInput, compareUserMoveAndBridge(userMoveInput, mBridge))) {
                retry(upperList, downList)
                break
            }
        }
        if(mBridge.size == 0) OutputView(upperList, downList).printResult(true, retryCount)
    }

    private fun compareUserMoveAndBridge(userMove : String, mBridge : MutableList<String>) : Boolean {
        return if (userMove == mBridge[0]) {
            mBridge.removeAt(0)
            true
        } else false
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private fun retry(upperList: MutableList<String>, downList: MutableList<String>) {
        if(UserInput().userInputRetry() == "R" || UserInput().userInputRetry() == "r") {
            retryCount++
            move()
        } else {
            OutputView(upperList, downList).printResult(false, retryCount)
        }

    }
}
