val num = listOf<Int>(1,2,3)

try{
    num[5]
}catch(e : ArrayIndexOutOfBoundsException){
    println("ArrayIndexOutOfBoundsException")
} finally{
    println("final")
}
