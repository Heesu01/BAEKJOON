n = int(input())
li=list(map(int,input().split()))
cnt=0
for i in range(5):
    if n==li[i]:
        cnt+=1
print(cnt)