import sys
input=sys.stdin.readline

n = int(input())
nums=[]
for _ in range(n):
    nums.append(int(input()))
new = sorted(nums)
for i in range(n):
    print(new[i])
