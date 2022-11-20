package bridge

import camp.nextstep.edu.missionutils.Console
import java.lang.Exception

class InputView {
    fun readBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        var bridgelength = BridgeInputcheck()
        return bridgelength
    }

    fun isNumber(s : String): Boolean {
        return when(s.toIntOrNull())
        {
            null -> false
            else -> true
        }
    }
    fun lengthwordcheck(a:String){
        var checklength = a.let { isNumber(it)}
        if(!checklength){
            println("[ERROR] 숫자만 입력해주세요.")
            throw IllegalArgumentException()
        }

    }
    fun readMoving(): String {
        println("이동할 칸을 선택해주세요.")
        var readmoving = movingselect()
        return readmoving
    }
    fun readGameCommand(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료: Q)")
        var retrycheck = retrycheck()
        return retrycheck
    }
    fun BridgeInputcheck(): Int {
        val bridgelengthstr = Console.readLine()
        lengthwordcheck(bridgelengthstr)
        val bridgelength = bridgelengthstr.toInt()
        if(!(bridgelength >= 3 && bridgelength <= 20)){
            println("[ERROR] 3부터 20까지의 숫자만 가능합니다.")
            throw IllegalArgumentException()
        }

        return bridgelength
    }
    fun movingselect(): String {
        var movingselect = Console.readLine()
        if(!(movingselect == "U" || movingselect == "D")) {
            println("[ERROR] U과 D만 입력할 수 있습니다.")
            throw IllegalArgumentException()
        }
        return movingselect
    }
    fun retrycheck(): String {
        var retrycheck = Console.readLine()
        if(!(retrycheck == "R" || retrycheck == "Q")) {
            println("[ERROR] R과 Q만 입력할 수 있습니다.")
            throw IllegalArgumentException()
        }
        return retrycheck
    }
}
