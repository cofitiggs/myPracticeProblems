# https://www.codewars.com/kata/515e271a311df0350d00000f

def square_sum(numbers):
    return sum(number**2 for number in numbers)

print(square_sum([1, 2, 2]))