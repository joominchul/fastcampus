var numbers = mutableListOf<Int>(1,2)
numbers[0] +=1
println(numbers)
numbers = mutableListOf<Int>(1,2,3,2)
numbers.add(0,100)
//numbers.removeAt(2)
println(numbers.size)
var set1 = mutableSetOf<Int>(1,2,2,3)
println(set1)
println(set1.containsAll(numbers))
set1.removeAll(numbers)
println(set1)

var map1 = mutableMapOf<Int, Int>(1 to 100, 2 to 200)
println(map1.getOrDefault(10, "rd"))
