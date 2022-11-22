package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        var Bridge = mutableListOf<String>()
        for (i in 0..size-1)
        {
            var selectnumber = bridgeNumberGenerator.generate()
            Bridge.add(updownjudgment(selectnumber))
        }
        return Bridge
    }
    fun updownjudgment(a:Int) : String {
        if (a == 0) {
            return "D"
        }
        if (a == 1) {
            return "U"
        }
        return "[ERROR] D와 U중에 입력해주세요."
    }
}
