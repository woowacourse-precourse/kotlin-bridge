package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
BridgeMaker의 필드를 변경할 수 없다.
BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
val number = bridgeNumberGenerator.generate()
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        val resultBridge: MutableList<String> = mutableListOf()
        val bridgeRandomNumber = bridgeNumberGenerator.generate()
        for(i in 0 until size){
            if(bridgeRandomNumber == 1){
                resultBridge[i] = "U"
            } else {
                resultBridge[i] = "D"
            }
        }
        return resultBridge.toList()
    }
}
