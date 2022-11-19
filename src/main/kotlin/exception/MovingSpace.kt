package exception

class MovingSpace(private val space: String) {
    init {
        require(space == "U" || space == "D") {
            print("[ERROR] 이동할 칸은 U(위)나 D(아래)여야 합니다.")
        }
    }
}