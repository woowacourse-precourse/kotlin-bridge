package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    var count = 1;
    var size = 0;
    var success = 0;
    fun gameStart() {
        OutputView.printGameStart()
        size = InputView.readBridgeSize()
        var bridgeList: List<String>;
        var inputList = emptyList<String>().toMutableList()
        val numberGenerator: BridgeNumberGenerator = BridgeRandomNumberGenerator()
        bridgeList = BridgeMaker(numberGenerator).makeBridge(size)
        var index = gameMove(inputList,bridgeList,0)
        inputList = checkResult(inputList,bridgeList,index)
        checkSuccess(inputList,bridgeList)
        OutputView.printResult(count, success)
    }
    fun checkSuccess(inputList: MutableList<String>, bridgeList: List<String>){
        if(inputList == bridgeList)
            success = 1
    }
    fun gameMove(inputList: MutableList<String>, bridgeList: List<String>, index: Int) : Int{
        var i = index
        while (i < size && move(inputList, bridgeList, i)) {
            OutputView.printMap(inputList,bridgeList, i)
            i++
        }
        return i
    }
    fun checkResult(inputList: MutableList<String>,bridgeList: List<String>,index: Int) : MutableList<String>{
        var tmpList = inputList
        if (tmpList != bridgeList) {
            OutputView.printMap(tmpList,bridgeList, index)
            if (InputView.readGameCommand() == "R") {
                count++
                tmpList = retry(bridgeList, size)
            }
        }
        return tmpList
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(inputList: MutableList<String>, bridgeList: List<String>, index: Int): Boolean {
        var tmp = InputView.readMoving()
        inputList.add(tmp)
        if (tmp == bridgeList[index])
            return true
        return false
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(bridgeList: List<String>, size: Int): MutableList<String> {
        var inputList = emptyList<String>().toMutableList()
        var index = gameMove(inputList,bridgeList,0)
        inputList = checkResult(inputList,bridgeList,index)
        return inputList
    }
}