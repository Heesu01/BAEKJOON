from itertools import permutations

def is_prime(num):
    if num < 2:
        return 0
    for i in range(2,num):
        if num%i==0:
            return 0
    return 1

def solution(numbers):
    nums = set()
    
    for length in range(1, len(numbers)+1):
        for p in permutations(numbers, length):
            num = int(''.join(p))
            nums.add(num)

    return sum(is_prime(x) for x in nums)