package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 *
 * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 *
 */
class OutputView {
    fun printMap(bridge : List<String>, movingResult : List<String>) {
        val upperMap = mutableListOf<String>()
        val lowerMap = mutableListOf<String>()
        for (i in 0 until movingResult.size) {
            if (movingResult[i] == "O" && bridge[i] == "U") {
                upperMap.add(" O ")
                lowerMap.add("   ")
            }
            if (movingResult[i] == "O" && bridge[i] == "D") {
                upperMap.add("   ")
                lowerMap.add(" O ")
            }
            if (movingResult[i] == "X" && bridge[i] == "U") {
                upperMap.add(" X ")
                lowerMap.add("   ")
            }
            if (movingResult[i] == "X" && bridge[i] == "D") {
                upperMap.add("   ")
                lowerMap.add(" X ")
            }
        }
        println(upperMap.toString().replace(", ","|"))
        println(lowerMap.toString().replace(", ","|"))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
