class Person(var name:String? = null, var age:Int? = null){

}

val gildong = Person().apply {
    name = "honggildong"
    age = 20
}

val gildong2 = Person().also {
    it.name = "honggildong2"
    it.age = 20
}


val age10 = Person("gildong", 10).run { age!! + 10 }
println(age10)

val gildong4 = Person().let {
    it.name = "honggildong4"
    it.age = 20
    30
}

println(gildong4)