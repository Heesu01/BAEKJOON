n,k = map(int,input().split())
li=[]
for _ in range(n):
    li.append(int(input()))
li.sort(reverse=True)

cnt=0
for i in li:
    if k>=i:
        cnt += (k//i)
        k %= i
        if k<=0:
            break
print(cnt)
    