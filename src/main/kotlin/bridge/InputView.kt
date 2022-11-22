package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        var bridgeSize = toBridgeSize()
        while(bridgeSize<3 || bridgeSize>20)
            bridgeSize = toBridgeSize()
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("\n이동할 칸을 선택해 주세요. (위: U, 아래: D)")
        var moveCommand = getMoveCommand()
        while(!moveCommand.equals("U") && !moveCommand.equals(("D")))
            moveCommand = getMoveCommand()
        return moveCommand
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        var gameCommand = getGameCommand()
        while(!gameCommand.equals("R") && !gameCommand.equals(("Q")))
            gameCommand = getGameCommand()
        return gameCommand
    }
    /**
     * 사용자가 입력한 값을 숫자로 변환한다.
     */
    private fun toInt() : Int {
        while(true){
            try{
                return Console.readLine().toInt()
            }catch (e : NumberFormatException ){
                println("[ERROR] 3이상 20이하의 숫자를 입력해 주세요.")
            }
        }
    }

    /**
     * 사용자가 입력한 값을 다리길이에 부합하는지 확인한다.
     */

    private fun toBridgeSize() : Int{
        var bridgeSize = 0
        try{
            bridgeSize = toInt()
            if(bridgeSize<3 || bridgeSize>20) throw IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해 주세요.")
        }catch( e : IllegalArgumentException){
            println(e)
        }
        return bridgeSize
    }

    private fun getMoveCommand() : String{
        var moveCommand = ""
        try{
            moveCommand = Console.readLine()
            if(!moveCommand.equals("U") && !moveCommand.equals(("D"))) throw IllegalArgumentException("[ERROR] U/D를 입력해주세요")
        }catch (e : IllegalArgumentException){
            println(e)
        }
        return moveCommand
    }

    private fun getGameCommand() : String{
        var gameCommand = ""
        try{
            gameCommand = Console.readLine()
            if(!gameCommand.equals("R") && !gameCommand.equals(("Q"))) throw IllegalArgumentException("[ERROR] R/Q를 입력해주세요")
        }catch (e : IllegalArgumentException){
            println(e)
        }
        return gameCommand
    }
}
