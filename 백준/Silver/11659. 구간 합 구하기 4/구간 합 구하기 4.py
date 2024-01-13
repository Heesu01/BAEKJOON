import sys
input = sys.stdin.readline

n,m = map(int,input().split())
nums = list(map(int,input().split()))
sum =[0]
temp = 0

for i in nums:
    temp += i
    sum.append(temp)
    
for i in range(m):
    a, b = map(int, input().split())
    print(sum[b]-sum[a-1])