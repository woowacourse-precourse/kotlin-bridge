package bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */

    var gamecnt : Int = 0
    var bridge : List<String> = listOf()
    fun makeBridge(size: Int): List<String> {
        var res = listOf<String>()
        var binbridge = makeBinaryBridgeList(size)
        binbridge.forEach { res.plus(binToString(it)) }
        this.bridge = res
        return res
    }

    /**
     * @return 0이면 D, 1이면 U를 리턴하는 함수
     * */
    fun binToString(bin : Int): String{
        return if (bin == 0) { "D" } else "U"
    }

    fun makeBinaryBridgeList(size: Int) : List<Int>{
        var res = listOf<Int>()
        for(i in 0 until size) { res.plus(bridgeNumberGenerator.generate()) }
        return res
    }
}
