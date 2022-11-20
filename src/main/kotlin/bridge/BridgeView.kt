package bridge

class BridgeView(val bridgeMaker : BridgeMaker, val inputView : InputView, val outputView: OutputView){
    private var bridge : List<String> = listOf()
    private var move = 0
    private var moveUpMap = ""
    private var moveDownMap = ""

    fun initBridge(){
        val size = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(size)
    }

    fun restart(){
        move = 0
        moveUpMap = ""
        moveDownMap = ""
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

        }
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