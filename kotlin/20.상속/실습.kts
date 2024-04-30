open class warrior(name:String = "any"){
    val name:String
    init {
        this.name = name
    }
    open fun attack(){
        println("attack " + name)
    }
}

//val w = warrior("king")
//w.attack()
class hardWarrior(sex:String):warrior("joo"){
    val sex:String
    init {
        this.sex=sex
    }
    fun hard(){
        println("hard attack " + sex)
    }

//    fun hard():Int{
//        println("hard attack " + sex)
//        return 10
//    }

    fun hard(power:String){
        println("hard attack " + power + " "+ sex)
    }

    override fun attack(){
        println("attack " + name + " hard")
    }

}

val warrior=hardWarrior("girl")
warrior.attack()
warrior.hard()
warrior.hard("20")