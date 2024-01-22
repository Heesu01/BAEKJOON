sum=0
for _ in range(4):
    time=int(input())
    sum+=time
m=sum//60
s=sum%60
print(m)
print(s)