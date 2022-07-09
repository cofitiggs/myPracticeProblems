# https://www.codewars.com/kata/57a083a57cb1f31db7000028

def powers_of_two(n):
    return [2**n for n in range(n+1)]

print(powers_of_two(5))