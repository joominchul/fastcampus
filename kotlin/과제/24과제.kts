//1. 변수 A와 B를 선언하고, 두 변수의 값이 같은 경우 트루, 그렇지 않은 경우 펄스가 되는
//변수 C를 선언한다. 단 변수 A와 B의 자료형은 자유지만 에러가 발생하면 안된다.
var A: Int = 10
var B: Int = 10
var C: Boolean = if (A == B) true else false
println(C)

//2. 정수형 변수 A를 선언하고, 변수 B를 선언한다. 이 때, 변수 B는 A의 두배가 되어야 한다.
A = 20
B = A * 2
println(B)

//3. 학생의 시험 점수를 넣어주면 학점을 반환하는 함수를 만드시오
//(90점 이상 A학점, 80~89점은 B학점, 70~79점은 C학점, 그렇지 않으면 F학점)
fun printGrade(result: Int): String {
    if (result >= 90) return "A학점"
    else if (result >= 80) return "B학점"
    else if (result >= 70) return "C학점"
    else return "F학점"
}
println(printGrade(70))

//4. 학생이 시험에서 맞은 문제의 갯수를 넣어주면 시험 점수를 반환하는 함수를 만드시오
fun examResult(result: Int): Int {
    return result * 5
}
println(examResult(18))

//5. nullable 정수형 2개를 받는 함수를 만든다. 이 함수는 받은 인수의 합을 반환한다.
//이때 인수중에 null이 있으면 0으로 취급하여 합을 구한다.
var nA: Int? = null
var nB: Int? = 4
fun add(f: Int?, s: Int?): Int {
    var first = f
    var second: Int? = s
    if (first == null) first = 0
    if (second == null) second = 0
    return first + second
}
println(add(nA, nB))

var s:Short = 10
var i = 20
println(i)