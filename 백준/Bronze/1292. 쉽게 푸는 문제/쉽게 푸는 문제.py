a,b=map(int,input().split())
li=[]
sum=0
for i in range(1,b+1):
    for _ in range(i):
        li.append(i)
for j in range(a,b+1):
    sum+=li[j-1]
print(sum)