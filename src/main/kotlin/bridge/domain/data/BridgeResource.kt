package bridge.domain.data

enum class BridgeKeyword(val keyword:String){
    PASS("O"),
    FAIL("X"),
    UP("U"),
    DOWN("D"),
    BLANK( " "),
    RETRY("R"),
    QUIT("Q")
}