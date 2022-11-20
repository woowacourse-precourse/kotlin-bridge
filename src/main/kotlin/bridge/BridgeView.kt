package bridge

class BridgeView(val bridgeMaker : BridgeMaker, val inputView : InputView, val outputView: OutputView){
    private var bridge : List<String> = listOf()
    private var move = 0
    private var moveUpMap = ""
    private var moveDownMap = ""
    private var tryCount = 1
    private var isEnd = false

    fun initBridge(){
        val size = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(size)
    }

    fun initialize(){
        move = 0
        moveUpMap = ""
        moveDownMap = ""
        isEnd = false
    }

    fun checkPlayerCanMove(input : String){
        val input = inputView.readMoving()
        var isFail = false
        when(input == bridge[move]){
            true -> checkSuccessDistinguishUpDown(input)
            false -> {
                checkFailDistinguishUpDown(input)
                isFail = true
            }
        }
        move++
        outputView.printMap()
        checkMoveEnd(move, isFail)
    }

    private fun checkSuccessDistinguishUpDown(input: String){
        when (input){
            "U" -> {
                upProcess("O")
                downProcess(" ")
            }

            "D" -> {
                upProcess(" ")
                downProcess("O")
            }
        }
    }

    private fun checkFailDistinguishUpDown(input: String){
        when(input){
            "U" -> {
                upProcess("X")
                downProcess(" ")
            }
            "D" -> {
                upProcess(" ")
                downProcess("X")
            }
        }
    }

    private fun checkMoveEnd(move : Int, isFail : Boolean){
        if(move == bridge.size || isFail){
            isEnd = true
        }
    }

    fun checkRestart() : Boolean{
        initialize()
        var restart = true
        when(inputView.readGameCommand()){
            "R" -> {
                tryCount++
                restart = true
            }
            "Q" -> {
                tryCount = 1
                restart = false
            }
        }
        return restart
    }

    private fun finalResult() {

    }

    private fun upProcess(result: String){
        val str = result + " | "
        moveUpMap = moveUpMap + str
        outputView.upMap(moveUpMap)
    }

    private fun downProcess(result: String){
        val str = result + " | "
        moveDownMap = moveDownMap + str
        outputView.downMap(moveDownMap)
    }
}