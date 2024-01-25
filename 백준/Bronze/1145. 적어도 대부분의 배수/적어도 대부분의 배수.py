import sys
input=sys.stdin.readline

nums=list(map(int,input().split()))

cnt=min(nums)
while True:
    check=0
    for i in nums:
        if cnt % i ==0:
            check+=1
    if check>=3:
        break
    cnt+=1
print(cnt)