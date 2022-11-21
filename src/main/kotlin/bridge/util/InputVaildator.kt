package bridge.util

import java.util.regex.Matcher
import java.util.regex.Pattern

class InputVaildator {

    fun checkNullBridgeSize(userInputNumber:String?){
        userInputNumber ?: println("[Error]")
        if (userInputNumber!!.isEmpty()||userInputNumber.length>2){
            throw IllegalArgumentException()
        }
    }

    //영어 문구 입력 널 값 길이 확인 기능
    fun checkNullBridgeString(userInputNumber:String?){
        userInputNumber ?: println("[Error]")
        if (userInputNumber!!.isEmpty()||userInputNumber.length>1){
            throw IllegalArgumentException()
        }
    }

    fun checkInputBridgePatten(checkOverlap: String) {
        val messageform = "^[0-9]*$"
        val pattern: Pattern = Pattern.compile(messageform)
        if (checkOverlap.toInt()<3||checkOverlap.toInt()>20) throw java.lang.IllegalArgumentException()
        for (inputNum in checkOverlap) {
            val matcher: Matcher = pattern.matcher(inputNum.toString())
            if (matcher.find().toString() == "false") {
                println("[ERROR]")
                throw IllegalArgumentException()
            }
        }
    }
}