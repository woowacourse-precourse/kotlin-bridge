package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 게임 시작 시 게임 시작 문구를 출력한다.
     */
    fun printGameStartMessage(){
        println(MESSAGE.GAMESTART.message)
    }
    /**
     * 정답인 경우 다리 출력
     * 단순 반복인 중간 부분은 따로 메소드 처리
     * @param index 어디까지 진행됐는지 확인한 지표
     * @param bridge 다리 모습
     * @param upDown 위 다리, 아래 다리 구분
     */
    fun printMapTrue(index:Int,bridge:List<String>,upDown:String){
        print(BridgePrint.START.message)
        printMapMiddle(index,bridge,upDown)
        if (bridge[index] == upDown)
            print(BridgePrint.TRUE_O_END.message)
        else
            print(BridgePrint.BLANK_END.message)
        print('\n')
    }
    /**
     * 오답인 경우 다리 출력
     * 단순 반복인 중간 부분은 따로 메소드 처리
     * @param index 어디까지 진행됐는지 확인한 지표
     * @param bridge 다리 모습
     * @param upDown 위 다리, 아래 다리 구분
     */
    fun printMapFalse(index:Int,bridge:List<String>,upDown:String){
        print(BridgePrint.START.message)
        printMapMiddle(index,bridge,upDown)
        if (bridge[index] != upDown)
            print(BridgePrint.FALSE_X_END.message)
        else
            print(BridgePrint.BLANK_END.message)
        print('\n')
    }
    /**
     * 단순 반복인 중간 부분 출력 (이 경우 정답, 오답 차이가 없음)
     * @param index 어디까지 진행됐는지 확인한 지표
     * @param bridge 다리 모습
     * @param upDown 위 다리, 아래 다리 구분
     */
    private fun printMapMiddle(index:Int,bridge:List<String>, upDown:String){
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
     * @param bridge 다리 모습
     * @param check 현재 정답인 경우인지 오답인 경우인지
     */
    fun printMap(index:Int,bridge:List<String>,check:Boolean) {
        if (check) {
            printMapTrue(index,bridge,BridgePrint.UP.message)
            printMapTrue(index,bridge,BridgePrint.DOWN.message)
        }
        if (!check) {
            printMapFalse(index,bridge,BridgePrint.UP.message)
            printMapFalse(index,bridge,BridgePrint.DOWN.message)
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    enum class MESSAGE(
        val message: String
    ) {
        GAMESTART("다리 건너기 게임을 시작합니다.")
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

}
