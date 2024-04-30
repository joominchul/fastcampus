val n : Int = 100

if (n<11){
    println("true")
}
else if (n > 11){
    println("tt")
}
else{
    println("fasl")
}

if (n==100) println(100)
else if (n<100) println(90)

val n1 = if (n>20) 10 else 30
when (n1){
    (100) -> {
        println("100")
    }
    else -> println("90")

}