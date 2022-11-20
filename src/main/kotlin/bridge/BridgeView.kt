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
        if(input == bridge[move]){
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
        outputView.printMap()
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