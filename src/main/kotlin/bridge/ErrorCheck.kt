package bridge

enum class ErrorMessage(val message: String){
    NOTHING("[ERROR] 아무것도 입력하지 않았습니다."),
    FORMATION("[ERROR] 올바르지 않은 형식입니다."),
    LENGTH("[ERROR] 올바르지 않은 길이입니다.")
}

class ErrorCheck {
    fun sentenceCheck(sentence : String) : Int{
        if (sentence == "") throw IllegalArgumentException(ErrorMessage.NOTHING.message)
        try{
            val checkSentence = sentence.toInt()
            return checkSentence
        } catch (e : NumberFormatException){
            throw NumberFormatException(ErrorMessage.FORMATION.message)
        }
    }

    fun movingCheck(move : String) : String {
        if (move == "") throw IllegalArgumentException(ErrorMessage.NOTHING.message)
        if (move.length != 1) throw IllegalArgumentException(ErrorMessage.LENGTH.message)
        return when(move){
            "U" -> move
            "D" -> move
            else -> throw IllegalArgumentException(ErrorMessage.FORMATION.message)
        }
    }

    fun commandCheck(command : String) : String {
        if (command == "") throw IllegalArgumentException(ErrorMessage.NOTHING.message)
        if (command.length != 1) throw IllegalArgumentException(ErrorMessage.LENGTH.message)
        return when(command){
            "R" -> command
            "Q" -> command
            else -> throw IllegalArgumentException(ErrorMessage.FORMATION.message)
        }
    }
}