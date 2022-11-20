package bridge.data

enum class Moves (
    val move:List<String>
){
    UP_RIGHT(listOf("O"," ")),
    UP_WRONG(listOf("X"," ")),
    DOWN_RIGHT(listOf(" ","O")),
    DOWN_WRONG(listOf(" ","X"))
}