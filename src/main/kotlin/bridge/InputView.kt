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
        return try{
            getBridgeSize()
        }catch (e:IllegalArgumentException) {
            println(e.message)
            readBridgeSize()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */

    private fun getBridgeSize(): Int{
        val size: Int
        try{
            size= Console.readLine().toInt()
            if(size<3 || size>20) throw IllegalArgumentException("[ERROR] 다리 길이는 3~20 입니다.")
        } catch(e:NumberFormatException){
            throw IllegalArgumentException("[ERROR] 숫자를 입력하세요.")
        }
        return size
    }





}
