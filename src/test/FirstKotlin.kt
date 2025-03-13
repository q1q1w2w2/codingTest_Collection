package test

class FirstKotlin {
    fun printNum(num : Int) {
        if (num > 0) {
            println("num = $num")
        }
    }
}

fun main() {
//    val instance = FirstKotlin()
    val number: Int = 5
    var sum: Int = 0

    for (i in number..10) {
//        instance.printNum(i)
        println(i)
        sum += i
    }
    println(sum)


}
