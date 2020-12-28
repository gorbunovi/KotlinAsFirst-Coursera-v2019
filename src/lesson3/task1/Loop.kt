@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1


import kotlin.math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }


/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var i = n
    var count: Int = 0
    do {
        count++
        i /= 10
    } while (i != 0)
    return count
}


/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var a = 1
    var b = 1
    if (n == 1 || n == 2) return 1
    else {
        for (i in 3..n) {
            b += a
            a = b - a
        }
    }
    return b
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var a = m
    var b = n
    while (a != 0 && b != 0) {
        if (a > b) a %= b
        else b %= a
    }
    val nod = a + b
    return m * n / nod
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var a = 2
    while (n % a != 0) a++
    return a
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var a = n - 1
    while (n % a != 0) a--
    return a
}


/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var a = m
    var b = n
    while (a != 0 && b != 0) {
        if (a > b) a %= b
        else b %= a
    }
    val nod = a + b
    return if (nod == 1) true else false
}


/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var count = 0
    val a = sqrt(n + 0.0)
    for (i in 1..a.toInt() + 1) {
        if (i * i in m..n) count++
    }
    return if (count == 0) false else true
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var a = x
    var count = 0
    while (a != 1) {
        if (a % 2 == 0) a /= 2 else a = 3 * a + 1
        count++
    }
    return count
}



/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var n = 1
    var a = x
    var sin = x
    var b = x
    var c = 1
    while (abs(sin) > eps) {
        b = -b * x * x
        c *= (n + 1) * (n + 2)
        n += 2
        sin = b / c
        a += sin
    }
    return a
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var x = n
    var revers = 0
    var a: Int
    while (x > 0) {
        a = x % 10
        x /= 10
        revers *= 10
        revers += a
    }
    return revers
}



/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var revers = revert(n)
    return if (revers == n) true else false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */

fun hasDifferentDigits(n: Int): Boolean {
    var a = n
    var b = a % 10
    a /= 10
    var resault = false
    while (a>0){
        if (a%10 != b){
            resault = true
            break
        }else{
            b = a % 10
            a /= 10
            resault = false
        }
    }
    return resault
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */

fun squareSequenceDigit(n: Int): Int {
    var a = 0
    var b = 0
    var count = 0
    for (i in 1..n){
        a = i * i
        when {
            a<10 -> count++
            a>=10 && a<100 -> count += 2
            a>=100 && a<1000 -> count += 3
            else -> count += 4
        }
        if (count>=n) break
    }
    if (count==n) b = a%10
    else {
        while (count > n) {
            count--
            a /= 10
            b = a%10
        }
    }
    return b
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun main() {
    println("fibSequenceDigit = ${fibSequenceDigit(20)}")
}
fun fibSequenceDigit(n: Int): Int {
    var a = 0
    var b = 0
    var count = 0
    for (i in 1..n){
        a = fib(i)
        when {
            a<10 -> count++
            a>=10 && a<100 -> count += 2
            a>=100 && a<1000 -> count += 3
            else -> count += 4
        }
        if (count>=n) break
    }
    if (count==n) b = a%10
    else {
        while (count > n) {
            count--
            a /= 10
            b = a%10
        }
    }
    return b
}
