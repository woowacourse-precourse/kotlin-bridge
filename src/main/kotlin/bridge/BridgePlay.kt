package bridge

class BridgePlay {

    fun playBridge(bridgeLength: Int,bridgeUpdown:List<String>,bridge:MutableList<String>):Boolean {
        for (i: Int in 0 until bridgeLength) {
            val case = BridgeGame().move(BridgeException().readMovingError(), bridgeUpdown[i])
            bridge.add(case)
            OutputView().printMap(bridge)
            if (case == "C" || case == "D")
                return BridgeGame().retry(readGame=BridgeException().readGameCommandError(),bridge)
        }
        return false
    }

    fun playResult(bridge: MutableList<String>):String{
        if(bridge.contains("C") || bridge.contains("D"))
            return "실패"
        return "성공"
    }

    fun playCount(count: Int,bridgeLength:Int,bridge: MutableList<String>):Int{
        if(bridgeLength == bridge.size)
            return count
        return count+1
    }
}