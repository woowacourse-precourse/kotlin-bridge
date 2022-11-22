package bridge
/**
 * UserInput 받기, 정답 오답 확인, Map 출력, 현재 상황 반환 기능 통합
 * @param index 어디까지 진행됐는지 확인한 지표
 * @param bridgeGame Bridge Game 관리 클래스
 * @param outputView 출력 클래스
 * @return 현재 상황 반환, 정답인 경우(1) 오답인 경우(0) 에러인 경우(-1)
 */
fun checkUserInput(index: Int, bridgeGame: BridgeGame,outputView: OutputView): Int {
    val result =  bridgeGame.move(index, InputView().readMoving())
    if(result == Result.USER_INPUT_CORRECT.message) {
        outputView.printMap(index, true)
        return Constant.CORRECT.params
    }
    if(result == Result.USER_INPUT_WRONG.message) {
        outputView.printMap(index,false)
        return Constant.WRONG.params
    }
    return Constant.ERROR.params
}
/**
 * UserGameCommand 받기. 재시도 할지 종료할지 받고 종료할 경우 최종결과 출력과정 추가
 * @param bridge 어디까지 진행됐는지 확인한 지표
 * @param tryCount 전체 Bridge Map
 * @return 재시도의 경우 playGame 다시 시작, 종료의 경우 최종결과 출력, Error(-1) 반환
 */
fun checkUserGameCommand(bridge: List<String>,tryCount: Int,idx:Int): Int {
    val userGameCommand = InputView().readGameCommand()
    if (userGameCommand==Result.USER_COMMAND_RETRY.message)
        return playGame(bridge, BridgeGame(bridge).retry(tryCount))
    if (userGameCommand==Result.USER_COMMAND_QUIT.message){
        OutputView(bridge).printResult(idx, tryCount)
        return Constant.WRONG.params
    }
    return Constant.ERROR.params
}
/**
 * 전체 게임을 진행하는 부분. bridge 배열을 앞에서부터 순회하면서 진행.
 * @param bridge 어디까지 진행됐는지 확인한 지표
 * @param tryCount 전체 Bridge Map
 * @return tryCount 반환. 중간의 Quit 나 Error 의 경우 각각 0, -1 반환
 */
fun playGame(bridge:List<String>,tryCount:Int): Int {
    for(idx in bridge.indices) {
        if (checkUserInput(idx, BridgeGame(bridge), OutputView(bridge))==Constant.WRONG.params) {
            return checkUserGameCommand(bridge,tryCount,idx)
        }
    }
    return tryCount
}
/**
 * 게임 초기값 설정 부분
 */
fun main() {
    println(OutputView.Message.GAMESTART.message)
    val size = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    val finalTryCount = playGame(bridge,Constant.TRY_COUNT.params)
    if (finalTryCount !=Constant.CORRECT.params || finalTryCount !=Constant.ERROR.params)
        OutputView(bridge).printResult(bridge.size,finalTryCount)
}
enum class Constant(
        val params:Int
){
    CORRECT(1),
    WRONG(0),
    ERROR(-1),
    TRY_COUNT(1)
}
enum class Result(
        val message:String
){
    USER_INPUT_CORRECT("Correct"),
    USER_INPUT_WRONG("Wrong"),
    USER_COMMAND_RETRY("R"),
    USER_COMMAND_QUIT("Q")
}