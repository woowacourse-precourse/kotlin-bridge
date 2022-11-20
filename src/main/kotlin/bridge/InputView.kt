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
        print("다리의 길이를 입력하세요")
        var a = Console.readLine().toString();
        var CheckTrue = CheckTrue()

        try {
            var lengthToInt =CheckTrue.checkBridgeLength(a);
            return lengthToInt
        }catch(e:IllegalArgumentException){
           print("[ERROR] 잘못 입력하셨습니다.")
            return -1
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
