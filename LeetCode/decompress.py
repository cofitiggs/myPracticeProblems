# https://leetcode.com/problems/decompress-run-length-encoded-list/

def decompress_rle_list(nums: list[int]) -> list[int]:
    quantity_and_number = {}
    for i in range(0, len(nums)):
        if i%2 == 1:
            quantity_and_number[nums[i-1]] = nums[i]
    
    solution = []
    for key, value in quantity_and_number.items():
        for _ in range(key):
            solution.append(str(value))

    return solution

print(decompress_rle_list([0,1,2,3,4,5]))
print(decompress_rle_list([10,1]))