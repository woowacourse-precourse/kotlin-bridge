package bridge

data class Status
    (var moveHistory: MutableList<String> = mutableListOf<String>(),
     var tryCount:Int=1,
     var success:String="실패") {
}