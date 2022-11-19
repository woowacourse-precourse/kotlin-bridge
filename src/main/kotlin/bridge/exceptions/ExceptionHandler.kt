package bridge.exceptions

class ExceptionHandler {

    fun checkSize(num : Int){
        if( num <=2 || num >=21){
            throw IllegalArgumentException("3 ~ 20 사이의 숫자를 입력해 주세요")
        }
    }
    fun checkUpDown(str: String){
        if(str != "U" && str != "D"){
            throw IllegalArgumentException("U 또는 D 를 눌러 주세요")
        }
    }
    fun checkCommand(str: String){
        if(str != "Q" && str != "R"){
            throw IllegalArgumentException("Q 또는 R 를 눌러 주세요")
        }
    }


}