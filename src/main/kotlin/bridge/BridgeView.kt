package bridge

class BridgeView(val bridgeMaker : BridgeMaker, val inputView : InputView, val outputView: OutputView){
    private var bridge : List<String> = listOf()
    private var move = 0
    private var moveUpMap = ""
    private var moveDownMap = ""
    private var tryCount = 1
    private var isEnd = false
    private var result = ""

    fun initBridge(){
        outputView.printStartMessage()
        outputView.printGetBridgeSizeMessage()
        val size = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(size)
    }

    private fun initialize(){
        move = 0
        moveUpMap = ""
        moveDownMap = ""
        isEnd = false
    }

    fun checkPlayerCanMove(){
        outputView.printGetMoveMessage()
        val input = inputView.readMoving()
        var isFail = false
        when(input == bridge[move++]){
            true -> checkSuccessDistinguishUpDown(input)
            false -> {
                checkFailDistinguishUpDown(input)
                isFail = true
            }
        }
        outputView.printMap()
        checkMoveEnd(move, isFail)
    }

    private fun checkSuccessDistinguishUpDown(input: String){
        when (input){
            UP -> {
                upProcess(SUCCESS)
                downProcess(EMPTY)
            }

            DOWN -> {
                upProcess(EMPTY)
                downProcess(SUCCESS)
            }
        }
    }

    private fun checkFailDistinguishUpDown(input: String){
        when(input){
            UP -> {
                upProcess(FAIL)
                downProcess(EMPTY)
            }
            DOWN -> {
                upProcess(EMPTY)
                downProcess(FAIL)
            }
        }
    }

    private fun checkMoveEnd(move : Int, isFail : Boolean){
        if(move == bridge.size){
            result = "성공"
            isEnd = true
        }
        else if(isFail){
            result = "실패"
            isEnd = true
        }
    }

    fun getGameIsEnd() : Boolean{
        return isEnd
    }

    fun getIsGameClear() : Boolean {
        var clear = false
        when(result){
            "성공" -> clear = true
            "실패" -> clear = false
        }
        return clear
    }

    fun checkRestart() : Boolean{
        initialize()
        var restart = true
        outputView.printRetryMessage()
        when(inputView.readGameCommand()){
            RETRY -> {
                tryCount++
                restart = true
            }
            QUIT -> {
                restart = false
            }
        }
        return restart
    }

    fun finalResult() {
        outputView.printResult(result, tryCount)
    }

    private fun upProcess(result: String){
        val str = result + " | "
        moveUpMap = moveUpMap + str
        outputView.upMap(moveUpMap)
    }

    private fun downProcess(result: String) {
        val str = result + " | "
        moveDownMap = moveDownMap + str
        outputView.downMap(moveDownMap)
    }
}