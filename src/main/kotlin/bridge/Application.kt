package bridge

fun main() {
    // TODO: 프로그램 구현
    gamestart()

}
fun gamestart(){
    print( "총 시도한 횟수: "+BridgeGame().move(BridgeGame().guideSet()))
}