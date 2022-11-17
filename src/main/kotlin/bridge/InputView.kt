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
        var bridgelength = BridgeInputcheck()
        return bridgelength
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요.")
        var readmoving = movingselect()
        return readmoving
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료: Q")
        var retrycheck = retrycheck()
        return retrycheck
    }

    fun BridgeInputcheck(): Int {
        var bridgelength = Console.readLine().toInt()
        try {
            require(bridgelength >= 3 && bridgelength <= 20) {
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR]bridgelength")
        }
        return bridgelength
    }

    fun movingselect(): String {
        var movingselect = Console.readLine()
        try {
            require(movingselect == "U" && movingselect == "D") {
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR] movingselect")
        }
        return movingselect
    }

    fun retrycheck(): String {
        var retrycheck = Console.readLine()
        try{
            require(retrycheck == "R" && retrycheck == "Q")
        } catch (e: IllegalArgumentException){
            throw IllegalArgumentException("[ERROR] retrycheck")
        }
        return retrycheck
    }
}
