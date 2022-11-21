package bridge.ui
import camp.nextstep.edu.missionutils.Console
import bridge.data.ErrorMessage.ERROR_NUM_NOT_IN_RANGE
import bridge.inputRangeException
import bridge.inputTypeException
import bridge.inputUpDownException

class InputView {
    fun readBridgeSize(): Int {
        while(true) {
            println("다리의 길이를 입력해주세요.")
            try{
                val bridgeSize = Console.readLine().inputTypeException()
                bridgeSize.inputRangeException()
                return bridgeSize
            }catch(e:IllegalArgumentException){
                println(e.message)
            }
        }
    }

    fun readMoving(): String {
        while(true){
            println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
            try {
                val moving = Console.readLine()
                moving.inputUpDownException()
                return moving
            }catch(e:IllegalArgumentException){
                println(e.message)
            }
        }
    }

    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val gameCommand = Console.readLine()
        return gameCommand
    }
}
