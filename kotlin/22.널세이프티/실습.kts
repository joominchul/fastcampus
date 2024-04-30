
var n:Int? = null
//!!
val nlist:List<Int?> = listOf<Int?>(1,2,null)
var r=0
nlist.forEach{
//    println(it)
//    n+=it!!
}
//?.
val s:String? = null
val ss:String = "ss"
println(s?.length)
println(ss.length)

//as?
open class c{
    fun p(){
        println("p")
    }
}
class cc{
    fun pp(){
        println("pp")
    }
}
var ccc = cc()
ccc.pp()
var cccc = ccc as? c
println(cccc)

//?:
var el:Int = s?.length ?: 4
println(el)
