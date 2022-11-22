package bridge

import bridge.constant.*
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(REQUEST_INPUT_BRIDGE_SIZE_MSG)
        while(true){
            try {
                val bridgeSize = camp.nextstep.edu.missionutils.Console.readLine().toInt()
                require(bridgeSize in 3..20)
                return bridgeSize
            }
            catch (e:IllegalArgumentException){
                println(ERROR_INPUT_BRIDGE_SIZE)
            }
        }
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
}
