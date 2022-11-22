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
        return toBridgeSize()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
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
        var bridgeSize = toInt()
        while(bridgeSize<3 || bridgeSize>20){
            println("3 이상 20이하의 숫자를 입력해 주세요.")
            bridgeSize = toInt()
        }
        return bridgeSize
    }
}
