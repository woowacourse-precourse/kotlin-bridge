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
        var s:String = "0"
        val regex = Regex("[0-9]{1,2}")


        while(true) {
            try {
                println("다리의 길이를 입력해주세요.")
                s = Console.readLine()
                if (!regex.matches(s)) {
                    throw IllegalArgumentException("[ERROR] 숫자입력")
                }
                if (s.toInt() !in 3..20) {
                    throw IllegalArgumentException("[ERROR] 3 20 사이")
                }
                break
            }catch (e:IllegalArgumentException){
                println(e.message)
            }
        }

        return s.toInt()


    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        var s:String = "0"


        while(true) {
            try {
                println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
                s = Console.readLine()
                if(s != "U" && s != "D"){

                    throw IllegalArgumentException("[ERROR] U or D")
                }
                break
            }catch (e:IllegalArgumentException){
                println(e.message)
            }
        }

        return s
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        var s:String = "0"


        while(true) {
            try {
                println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
                s = Console.readLine()
                if(s != "R" && s != "Q"){

                    throw IllegalArgumentException("[ERROR] R or Q")
                }
                break
            }catch (e:IllegalArgumentException){
                println(e.message)
            }
        }


        return s
    }
}
