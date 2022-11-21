package bridge.model.data

enum class GameStatus(val gameMsg: String) {
    CONTINUING(""), SUCCEEDED("성공"), FAILED("실패")
}
