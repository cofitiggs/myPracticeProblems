#Project Euler Problem 1

#Problem Name: Multiples of 3 and 5

#Link: https://projecteuler.net/problem=1


"""
---BEGIN PROBLEM STATEMENT---

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

---END OF PROBLEM STATEMENT---


First scratch work:

We are adding up all numbers less than 1000 that are multiples of 3 and/or 5.

So, set should go as follows:

3, 5, 6, 9, 12, 15, 18, 20, 21...

"""

def sum_of_multiples_under_1000():
	return sum(num for num in range(1, 1000) if num%3==0 or num%5==0)

print(sum_of_multiples_under_1000())
