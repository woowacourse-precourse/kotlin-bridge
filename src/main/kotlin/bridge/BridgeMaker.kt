package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    // 1.랜덤 값 생성 (0,1)->(D,U) 2.list 저장
    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        for (i in 0 until size) {
            when (bridgeNumberGenerator.generate()) {
                0 -> bridge.add("D")
                1 -> bridge.add("U")
            }
        }
        return bridge
    }
}
