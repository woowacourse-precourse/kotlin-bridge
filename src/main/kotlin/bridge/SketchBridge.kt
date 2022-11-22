package bridge

class SketchBridge {

    companion object{
        var movingUpside = mutableListOf<String>()
        var movingDownside = mutableListOf<String>()
    }

    fun upBridge(moving:List<String>){
        if(moving.last() == "U") movingUpside.add("O")
        else if(moving.last() == "UF") movingUpside.add("X")
        else if(moving.last() == "D" || moving.last() == "DF") movingUpside.add(" ")
    }

    fun downBridge(moving:List<String>){
        if(moving.last() == "D") movingDownside.add("O")
        else if(moving.last() == "DF") movingDownside.add("X")
        else if(moving.last() == "U" || moving.last() == "UF") movingDownside.add(" ")
    }

}