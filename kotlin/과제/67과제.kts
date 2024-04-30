//계산기 1
//사칙연산에 대응하는 4개의 함수 구현
//연산이 한번 이루어질 때마다 출력을 해야한다.
//사칙 연산 함수에서 출력을 하면 안된다.

class CalOne{
    var result:Double = 0.0
        set(value) {
            field = value
            println("결과 : " + field)
        }
    fun plus(a:Double, b:Double){
        result = a + b
    }
    fun minus(a:Double, b:Double){
        result = a - b
    }
    fun mul(a:Double, b:Double){
        result = a * b
    }
    fun div(a:Double, b:Double){
        result = a / b
    }
}

var cal = CalOne()
cal.div(4.0,7.0)


//사칙연산을 할 수 있는 1개의 함수 구현.
//초기값 할당 가능. 기본값 0
//불가능한 연산일 경우 에러 출력
class CalTwo(num:Int = 0){
    val number:Int
    init {
        number = num
    }
    fun cal(c:Char, a:Int){
        when(c){
            ('+') -> {
                println(number+a)
            }
            ('-') -> {
                println(number-a)
            }
            ('*') -> {
                println(number*a)
            }
            ('/') -> {
                println(number/a)
            }
            else -> println("error")
        }
    }
}

var cal2 = CalTwo(7)
cal2.cal('.', 4)

//사칙연산 1개 함수 구현
//한번에 여러개의 연산 입력 받음.
class CalThree(num:Int){
    var num:Int = num
        set(value) {
            field = value
            println("중간 결과 : " + field)
        }
    fun cal(arr:List<String>){
        arr.forEach {
            var len:Int = it.length
            var c:String = ""
            var n:Int = 0
            for (i in 0..len-2){
                c+=it[i]
            }
            println("c : "+c)
            n=it[len-1].digitToInt()
            when(c){
                "더하기" -> num+=n
                "빼기" -> num-=n
                "곱하기" -> num*=n
                "나누기" -> num/=n
            }
        }
    }
}

var cal3 = CalThree(7)
cal3.cal(listOf<String>("더하기3", "빼기5", "곱하기2", "나누기5"))
println(cal3.num)