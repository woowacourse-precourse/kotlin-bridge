package bridge.util

import java.util.regex.Matcher
import java.util.regex.Pattern

class InputValidator {
    companion object{
        const val ERRORNULLMSG="[ERROR] 입력 길이가 초과하거나 부족합니다."
        const val SIZEMSG="[ERROR] 입력은 한자리의 양식만 가능합니다."
        const val BRIDGESIZEMSG="[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 한다."
        const val CHOOSEBRIDEG="[ERROR] U,D 를 입력해 주세요."
        const val CHOOSERETRY="[ERROR] R,Q 를 입력해 주세요."
    }
    fun checkNullBridgeSize(userInputNumber: String?) {
        userInputNumber ?: println("[Error]")
        if (userInputNumber!!.isEmpty() || userInputNumber.length > 2) {
            println(ERRORNULLMSG)
            throw IllegalArgumentException()
        }
    }

    //영어 문구 입력 널 값 길이 확인 기능
    fun checkNullBridgeString(userInputNumber: String?) {
        userInputNumber ?: println("[Error]")
        if (userInputNumber!!.isEmpty() || userInputNumber.length > 1) {
            println(SIZEMSG)
            throw IllegalArgumentException()
        }
    }

    fun checkBridgeSizePatten(checkOverlap: String) {
        val messageform = "^[0-9]*$"
        val pattern: Pattern = Pattern.compile(messageform)
        if (checkOverlap.toInt() < 3 || checkOverlap.toInt() > 20) throw java.lang.IllegalArgumentException()
        for (inputNum in checkOverlap) {
            val matcher: Matcher = pattern.matcher(inputNum.toString())
            if (matcher.find().toString() == "false") {
                println(BRIDGESIZEMSG)
                throw IllegalArgumentException()
            }
        }
    }

    fun checkSelectBridgePatten(checkOverlap: String) {
        val messageform = "^[U,D]*$"
        val pattern: Pattern = Pattern.compile(messageform)
        val matcher: Matcher = pattern.matcher(checkOverlap)
        if (matcher.find().toString() == "false") {
            println(CHOOSEBRIDEG)
            throw IllegalArgumentException()
        }
    }

    fun checkRetryPatten(checkOverlap: String) {
        val messageform = "^[R,Q]*$"
        val pattern: Pattern = Pattern.compile(messageform)
        val matcher: Matcher = pattern.matcher(checkOverlap)
        if (matcher.find().toString() == "false") {
            println(CHOOSERETRY)
            throw IllegalArgumentException()
        }
    }
}