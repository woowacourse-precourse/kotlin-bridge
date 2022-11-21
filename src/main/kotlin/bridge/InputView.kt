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
        val bridgeSize = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력 하셔야합니다.")
        if(bridgeSize < 3 || bridgeSize > 20){
            throw IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
        }
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val moving = Console.readLine()
        if(moving != "U" && moving != "D"){
            throw IllegalArgumentException("[ERROR] 위 칸 : U, 아래 칸 : D 입력 하셔야합니다.")
        }
        return moving
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val gameCommand = Console.readLine()
        if(gameCommand != "R" && gameCommand != "Q"){
            throw IllegalArgumentException("[ERROR] 재시도: R, 종료: Q 입력 하셔야합니다.")
        }
        return gameCommand
    }
}
