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
        println("다리의 길이를 입력하세요")
        val size = Console.readLine().toString();
        val checkTrue = CheckTrue()

        try {
            val lengthToInt =checkTrue.checkBridgeLength(size);
            return lengthToInt
        }catch(e:IllegalArgumentException){
           println("[ERROR] 잘못 입력하셨습니다.")
            return -1
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        var way = Console.readLine()
        val checkTrue = CheckTrue()
        try {
             way =checkTrue.checkMove(way);
            return way
        }catch(e:IllegalArgumentException){
            println("[ERROR] 잘못 입력하셨습니다.")
            return "E"
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        var again = Console.readLine()
        val checkTrue = CheckTrue()
        try{
            again = checkTrue.checkAgain(again)
            return again
        }catch(e:IllegalArgumentException){
            println("[ERROR] 잘못 입력하셨습니다.")
            return "E"
        }
    }
}
