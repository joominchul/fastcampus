interface Tiger{
    fun bite()
    fun goToBox()
}
class BackTiger:Tiger{
    override fun bite() {
//        println("bite")
    }

    override fun goToBox() {
        println("go to box")
    }
}

val backTiger:BackTiger = BackTiger()
backTiger.bite()