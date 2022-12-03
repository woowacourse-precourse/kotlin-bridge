package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printData(data: String){
        println(data)
    }

    fun startGame(): String{
        return("다리 건너기 게임을 시작합니다.")
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(data:String):String{
        return data
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(playTime: Int, isSuccess: Boolean, data: String) :String{
        var success = ""
        if(isSuccess)
            success = "성공"
        if(!isSuccess)
            success = "실패"
        return "최종 게임 결과\n${data}\n\n게임 성공 여부: ${success}\n총 시도한 횟수: ${playTime}"
    }
}
