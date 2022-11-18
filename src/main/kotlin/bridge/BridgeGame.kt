package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(upOrDown: String,bridge:List<String>, index: Int): String {
        var answer=""
        //BridgeMaker에서 만든 리스트의 값과 맞다면 O 반환 틀리다면 X 반환
        if (upOrDown==bridge[index]){
            answer = "O"
        }else if(upOrDown!=bridge[index]){
            answer = "X"
        }
        return answer
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        // map을 초기화해준다.

    }

    fun askRetry() {
        // map의 첫번째, 두번째 리스트 마지막 요소가 X인지 확인하고

    }

    val answer = arrayListOf<String>("", "")
    fun buildMap(choose: String, oOrX: String) : List<String> {
        if (choose=="U") {
            answer[0]+=oOrX
            answer[1]+=" "
        }else if (choose=="D"){
            answer[0]+=" "
            answer[1]+=oOrX
        }
        return answer
    }
    var mapBuild1 = ""
    fun mapBuilder1(temp: String, cnt:Int) : String {
        for (i in 0 until 4){
            if (i==2) mapBuild1+=temp[cnt]
            else if (i%2==1) mapBuild1+=" "
            else if (i==0 && cnt!=0) mapBuild1+="|"

        }
        println(mapBuild1)
        return mapBuild1
    }

    var mapBuild2 = ""
    fun mapBuilder2(temp: String, cnt:Int) : String {
        for (i in 0 until 4){
            if (i%2==1) mapBuild2+=" "
            else if (i==0 && cnt !=0) mapBuild2+="|"
            else if (i==2) mapBuild2+=temp[cnt]
        }
        println(mapBuild2)
        return mapBuild2
    }

}
