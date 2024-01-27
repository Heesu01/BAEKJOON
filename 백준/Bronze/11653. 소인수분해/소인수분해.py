n=int(input())
li=[]
for i in range(2,n+1):
    while n%i==0:
        li.append(i)
        n=n/i
    if n/i==1:
        break
for i in li:
    print(i)