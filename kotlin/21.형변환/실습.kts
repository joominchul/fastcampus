val s:String="10.5"
val d:Double=10.9
val ns:Int=d.toInt()
//println(ns)

open class warrior(name:String = "any"){
    val name:String
    init {
        this.name = name
    }
    open fun attack(){
        println("attack " + name)
    }
}
class hardWarrior(sex:String):warrior("joo"){
    val sex:String
    init {
        this.sex=sex
    }
    fun hard(){
        println("hard attack " + sex)
    }

    fun hard(power:String){
        println("hard attack " + power + " "+ sex)
    }

    override fun attack(){
        println("attack " + name + " hard")
    }

}

val warrior:warrior = hardWarrior("woman")
warrior.attack()
if (warrior is hardWarrior) {
    println("yes")
    warrior.hard()
}

var i:Int = d as Int
println(i)