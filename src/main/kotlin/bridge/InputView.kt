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
        println("다리의 길이를 입력해주세요.")
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
            println("[ERROR] 3부터 20까지의 숫자만 가능합니다.")
            throw IllegalArgumentException()
        }
        return bridgelength
    }

    fun movingselect(): String {
        var movingselect = Console.readLine()
        try {
            require(movingselect == "U" || movingselect == "D")
        } catch (e: IllegalArgumentException) {
            println("[ERROR] U과 D만 입력할 수 있습니다.")
            throw IllegalArgumentException()
        }
        return movingselect
    }

    fun retrycheck(): String {
        var retrycheck = Console.readLine()
        try{
            require(retrycheck == "R" || retrycheck == "Q")
        } catch (e: IllegalArgumentException){
            println("[ERROR] R과 Q만 입력할 수 있습니다.")
            throw IllegalArgumentException()
        }
        return retrycheck
    }
}
