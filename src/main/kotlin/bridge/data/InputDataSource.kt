package bridge.data

/**
 * @author onseok
 * 입력한 데이터를 저장하고 관리하는 역할을 하는 클래스
 */
object InputDataSource {
    var bridgeSize: Int = 0
    var bridgeState: ArrayList<String> = arrayListOf()
    var bridgeMapUp: StringBuilder = StringBuilder()
    var bridgeMapDown: StringBuilder = StringBuilder()
    var movingCommands: ArrayList<String> = arrayListOf()
    var gameCommand: String = ""
    var numberOfTry: Int = 1

    /**
     * @author onseok
     * 게임을 재시작할 때, 초기화하는 메서드
     */
    fun initDataSource() {
        bridgeMapUp.clear()
        bridgeMapDown.clear()
        movingCommands = arrayListOf()
        gameCommand = ""
    }

    /**
     * @author onseok
     * 게임을 처음 시작할 때, 전체 데이터를 초기화 하는 메서드
     */
    fun initAllDataSource() {
        bridgeSize = 0
        bridgeState = arrayListOf()
        bridgeMapUp.clear()
        bridgeMapDown.clear()
        movingCommands = arrayListOf()
        gameCommand = ""
        numberOfTry = 1
    }
}