fun add(n1:Int, n2:Int): Int{
    return n1 + n2
}

fun add1(function: (Int, Int) -> Int){
    println(function(7,4))
}

fun add2(function: () -> Int){
    println(function())
}

add1(::add)

val number = {n1:Int, n2:Int ->
    println("lamda")
    n1+n2
}
number(4,6)
add1{a, b -> a+b}

val num: () -> Int = {
    println("lam")
    10+9
}
println(num())
val addlam: (String) -> String = {
    println(it)
    it
}

addlam("hard")