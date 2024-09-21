n,m = map(int,input().split())
listen=set()
see=set()
for _ in range(n):
    listen.add(input())
for _ in range(m):
    see.add(input())
    
result=[]
for i in listen:
    if i in see:
        result.append(i)

result.sort()
print(len(result))
for i in result:
    print(i)