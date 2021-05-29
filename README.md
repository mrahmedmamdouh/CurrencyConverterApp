# CurrencyConverterApp

Add arithmetic operators (add, subtract, multiply, divide) to make the following expressions true. You can use any parentheses you’d like. You don’t need to write any code for this question.

3 1 3 9 = 12

Solution :

    (3+1)/3*9 = 12


Write a function in Kotlin to determine whether two strings are anagrams or not (examples of anagrams: debit card/bad credit, punishments/nine thumps, etc.)

Solution :


  fun checkAnagrams(input1: String, input2: String): Boolean {

          if (input1.length != input2.length) {
              return false
          }

          val array1 = input1.toCharArray()
          val array2 = input2.toCharArray()
          array1.sort()
          array2.sort()
          val sortedString1 = String(array1)
          val sortedString2 = String(array2)
          return sortedString1 == sortedString2
      }

Write a function in Kotlin to generate the nth Fibonacci number (1, 1, 2, 3, 5, 8, 13, 21, 34)
recursive approach

Solution :

 fun generateFibonacciByRecursion(input: Int): Int {
        if (input <= 1) return input
        return generateFibonacciByRecursion(input - 1) + generateFibonacciByRecursion(input - 2)
    }

iterative approach

Solution :

 fun generateFibonacciByIteration() {
        val n = 10
        var t1 = 1
        var t2 = 1

        for (i in 1..n) {
            print("$t1, ")

            val sum = t1 + t2
            t1 = t2
            t2 = sum
        }
    }

