package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int{
        val temp = Console.readLine() ?: "-1"

        for(c in temp){
            if(c !in '0'..'9')
                throw IllegalArgumentException("[ERROR] 숫자가 아닙니다")
        }

        val sizeBridge = temp.toInt()

        if(sizeBridge<3 || sizeBridge>20)
            throw IllegalArgumentException("[ERROR] 숫자가 다리의 범위 밖입니다")

        return sizeBridge
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val temp = Console.readLine() ?:"A"

        if(temp != "U"&&temp !="D")
            throw IllegalArgumentException("[ERROR] 올바른 입력을 하세요")

        return temp
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val temp = Console.readLine() ?: "A"

        if(temp != "R"&&temp !="Q")
            throw  IllegalArgumentException("[ERROR] 올바른 입력을 하세요")

        return temp
    }
}
