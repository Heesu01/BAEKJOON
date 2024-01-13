n = int(input())
fact =1
cnt=0
for i in range(1,n+1):
    fact *= i

fact = str(fact)
fact = fact[::-1]

for i in fact:
    if i =='0':
        cnt+=1
    else:
        break
print(cnt)