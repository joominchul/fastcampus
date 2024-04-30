class person{
    var p:String = "per"
        get() {
            println("get")
            return field
        }
        set(value) {
            println("set")
            field = value
        }
    var name:String
    var age:Int
    constructor(name:String, age:Int){
        this.name=name
        this.age=age
    }
}
class user1 (name: String){
    var age:Int=0
    val name:String
    init {
        this.name = name
        println("init")
    }

    constructor(name: String, age:Int): this(name){
        this.age = age
        println("se")
    }
}
val p = person("주", 27)
//val u = user1("kim", 10)
//p.p = "person"
//println(p.p)

class late{
    lateinit var age:String
    fun late1(){
        if (::age.isInitialized) println(age)
        else println("no")
    }
}
//val l = late()
//l.age = "15"
//l.late1()
//println()

class lazy{
    val title: Int by lazy {
        123
    }
}

val l = lazy()
print(l.title)