# https://www.codewars.com/kata/56fc55cd1f5a93d68a001d4e

def stairs_in_20(stairs):
    return sum([sum(list) for list in stairs]) * 20

# print(stairs_in_20(stairs))