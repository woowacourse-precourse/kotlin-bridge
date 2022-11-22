package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView(private val bridge : List<String>) {

    /**
     * 정답인 경우 다리 출력
     * 단순 반복인 중간 부분은 따로 메소드 처리
     * @param index 어디까지 진행됐는지 확인한 지표
     * @param upDown 위 다리, 아래 다리 구분
     */
    fun printMapTrue(index:Int,upDown:String){
        print(BridgePrint.START.message)
        printMapMiddle(index,upDown)
        if (bridge[index] == upDown)
            print(BridgePrint.TRUE_O_END.message)
        else
            print(BridgePrint.BLANK_END.message)
        println()
    }
    /**
     * 오답인 경우 다리 출력
     * 단순 반복인 중간 부분은 따로 메소드 처리
     * @param index 어디까지 진행됐는지 확인한 지표
     * @param upDown 위 다리, 아래 다리 구분
     */
    fun printMapFalse(index:Int,upDown:String){
        print(BridgePrint.START.message)
        printMapMiddle(index,upDown)
        if (bridge[index] != upDown)
            print(BridgePrint.FALSE_X_END.message)
        else
            print(BridgePrint.BLANK_END.message)
        println()
    }
    /**
     * 단순 반복인 중간 부분 출력 (이 경우 정답, 오답 차이가 없음)
     * @param index 어디까지 진행됐는지 확인한 지표
     * @param upDown 위 다리, 아래 다리 구분
     */
    private fun printMapMiddle(index:Int, upDown:String){
        for (idx in 0 until index) {
            if (bridge[idx] == upDown)
                print(BridgePrint.MIDDLE_O.message)
            else
                print(BridgePrint.MIDDLE_BLANK.message)
        }
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * 정답인 경우와 오답인 경우를 나눠서 출력한다.
     * @param index 어디까지 진행됐는지 확인한 지표
     * @param check 현재 정답인 경우인지 오답인 경우인지
     */
    fun printMap(index:Int,check:Boolean) {
        if (check) {
            printMapTrue(index,BridgePrint.UP.message)
            printMapTrue(index,BridgePrint.DOWN.message)
        }
        if (!check) {
            printMapFalse(index,BridgePrint.UP.message)
            printMapFalse(index,BridgePrint.DOWN.message)
        }
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param index: 현재 진행 상황 -> 이 값으로 성공인지 실패인지 확인
     * @param tryCount: 현재까지 시도 횟수
     */
    fun printResult(index: Int, tryCount:Int) {
        println(Message.FINAL_RESULT_PRINT.message)
        if(index == bridge.size)
            printResultMapTrue(index-1)
        if (index != bridge.size)
            printResultMapFalse(index)
        println(Message.FINAL_TRY_COUNT.message+tryCount)
        return
    }
    /**
     * 성공일 경우 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param index: 성공인 경우이므로 bridge.size -1 값이다.
     */
    private fun printResultMapTrue(index: Int){
        printMapTrue(index,BridgePrint.UP.message)
        printMapTrue(index,BridgePrint.DOWN.message)
        println(Message.FINAL_RESULT_SUCCESS.message)
    }
    /**
     * 실패일 경우 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param index: Quit 하기 전까지의 상황
     */
    private fun printResultMapFalse(index: Int){
        printMapFalse(index,BridgePrint.UP.message)
        printMapFalse(index,BridgePrint.DOWN.message)
        println(Message.FINAL_RESULT_FAIL.message)
    }
    enum class BridgePrint(
        val message: String
    ){
        START("["),
        MIDDLE_O(" O |"),
        MIDDLE_BLANK("   |"),
        TRUE_O_END(" O ]"),
        FALSE_X_END(" X ]"),
        BLANK_END("   ]"),
        UP("U"),
        DOWN("D")
    }
    enum class Message(
        val message: String
    ){
        GAMESTART("다리 건너기 게임을 시작합니다."),
        FINAL_RESULT_PRINT("최종 게임 결과"),
        FINAL_RESULT_SUCCESS("게임 성공 여부: 성공"),
        FINAL_RESULT_FAIL("게임 성공 여부: 실패"),
        FINAL_TRY_COUNT("총 시도한 횟수: ")
    }

}
