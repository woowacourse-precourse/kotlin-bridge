package bridge

class BridgeGame(bridgeMaker: BridgeMaker, size: Int) {
    val makeBridge = bridgeMaker.makeBridge(size)
    val moveBlock = mutableListOf<String>()
    var tryCnt = 1

    fun move(selectBlock: String) {
        moveBlock.add(selectBlock)
    }

    fun retry() {
        moveBlock.clear()
        tryCnt++
    }

    fun isEnd(): Boolean {
        if(moveBlock.isEmpty()) return false
        if(moveBlock.size == makeBridge.size) return true
        if(isSuccess()) return false
        return true
    }

    fun isSuccess(): Boolean = moveBlock == makeBridge.subList(0, moveBlock.size)
}
