//주어진 문자를 N번 반복해서 출력하는 함수 만들기.
fun fun1(c:Char, n:Int):Unit{
    for (i in 1..n) println(c)
}
fun1('s', 5)

println("----------------")

//1부터 주어진 숫자까지의 합을 구하는 함수
fun fun2(n:Int):Int{
    var answer = 0
    for (i in 1..n) answer+=i
    return answer
}
println(fun2(10))

println("----------------")

//1부터 100까지의 수 중에서 7의 배수의 합을 구하는 함수
fun fun3():Unit{
    var answer = 0
    for (i in 1..100){
        if (i%7 == 0) answer+=i
    }
    println(answer)
}
fun3()

println("----------------")

//100보다 작은 숫자를 넣어주면 1씩 증가시키고 100이 되면 종료되는 함수를 만드시오.
fun fun4(n:Int):Unit{
    var answer = n
    while (answer<100){
        answer++
    }
    println(answer)
}

fun4(90)
println("----------------")

//시험 성적 리스트 [70, 71, 72, 77, 78, 79, 80, 82, 90, 99] 와 동일한 크기의
//배열을 만들고 80 이상이면 true, 아니면 false를 담는 함수를 만드시오.

fun fun5(list: List<Int>):Unit{
    var arr = Array<Boolean>(list.size, {false})
    for (i in 0 until list.size){
        if (list[i] >= 80) arr[i] = true
        println(arr[i])
    }
    println(arr)
}
fun5(listOf(70, 71, 72, 77, 78, 79, 80, 82, 90, 99))
println("----------------")

//두개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 함수. 중첩리스트.

fun fun6():Unit{
    var li = mutableListOf<List<Int>>()
    var idx = 0
    for (i in 1..6){
        for (j in 1..6){
            if (i+j==6) {
                li.add(listOf(i, j))
                idx++
            }
        }
    }
    println(li)
}

fun6()
println("----------------")

//배가 부른 횟수, 먹은 횟수를 인자로 주고, 밥을 먹을 때마다 "밥을 먹었다"를 출력하고
//횟수를 1 더해준다. 배가 부르면 "배가 부르다"를 출력한다. 배가 아무리 불러도 최소 한번은
//무조건 먹는다.

fun fun7(full:Int, eated:Int):Unit{
    var eat = eated
    do {
        println("밥을 먹었다")
        eat++
    }while (eat<full)
    println("배가 부르다")
}

fun7(3,3)
println("----------------")

//병사 그룹 2개와 n번째 값을 넣어주면, 각각의 병사 그룹에서 n번째 병사를 제거하고,
// 두개의 병사 그룹을 합쳐주는 함수를 만드시오. 중첩 리스트. 실행이 어려운 경우 널 리턴.
fun fun8(f:MutableList<String>, s:MutableList<String>, n:Int):Unit{
    var army = mutableListOf<List<String>>()
    var first = f
    var second = s
    if (f.size < n || s.size < n) println(null)
    else{
        first.removeAt(n)
        second.removeAt(n)
        army.add(first)
        army.add(second)
        println(army)
    }
}
var first = mutableListOf<String>("A", "b", "c", "d","e")
var second = mutableListOf<String>("a","q", "w")
fun8(first, second, 1)

println("----------------")
//단수를 입력 받아 해당 단수의 값을 리스트로 출력하는 함수를 만드시오.
fun fun9(n:Int):Unit{
    var li = mutableListOf<Int>()
    for (i in 1..9){
        li.add(n*i)
    }
    println(li)
}

fun9(3)
println("----------------")
//숫자 리스트 2개를 넣어주면 짝수와 홀수로 분리된 맵을 만드는 함수를 만드시오.
//짝수는 키가 "짝수", 홀수는 키가 "홀수"
fun fun10(f:List<Int>, s:List<Int>):Unit{
    var m = mutableMapOf<String, List<Int>>()
    var totalList = mutableListOf<Int>()
    totalList.addAll(f)
    totalList.addAll(s)

    var even = mutableListOf<Int>()
    var odd = mutableListOf<Int>()

    totalList.forEach {
        if (it%2==0) even.add(it)
        else odd.add(it)
    }

    m["짝수"] =  even
    m["홀수"] = odd

    println(m)
}

fun10(listOf(1,2,3,4,5), listOf(4,5,6,7))
println("----------------")
println("----------------")