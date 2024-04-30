val arr = listOf<Int>(7, 4, 6, 9)
for ((idx, i) in arr.withIndex()) {
    if (i == 6) {
        continue
    }
    println("" + idx + "/" + i)

}

//println("-----------")
//var i: Int = 0
//wh213@while (i < 5) {
//    println("****i : "+ i)
//    i += 1
//    arr.forEach {
//
//        if (i==3) {
//            return@wh213
//        }
//        println("it : " + it)
//    }
//
//}


//loop@for (i in 1..5){
//    println("****i : "+ i)
//    for (j in 1..5){
//        println("j : "+ j)
//        if (j==4 && i==2){
//            break@loop
//        }
//    }
//}