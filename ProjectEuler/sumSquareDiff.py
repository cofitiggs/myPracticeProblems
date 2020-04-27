#Project Euler Problem 6

#Problem Name: Sum square difference

#Link: https://projecteuler.net/problem=6


"""
---BEGIN PROBLEM STATEMENT---

The sum of the squares of the first ten natural numbers is,

1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)^2 = 55^2 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

--END OF PROBLEM STATEMENT---

First scratch work:
Sum of squares:
	Need variable to store sum
	Need to increment each number and square each number
	Add square to sum variable

Square of sums:
	Need variable to store sum
	Need to increment each number and add after each increment
	After 100 is added square sum variable

Subtract the two numbers

"""

sumSquares=squareSum=diff=sumNoSquare=0

for x in range(1, 101):
	sumSquares+=pow(x,2)

for x in range(1, 101):
	sumNoSquare+=x
squareSum=pow(sumNoSquare,2)
diff=sumSquares-squareSum
print (abs(diff))
