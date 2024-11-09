N,L = map(int,input().split())
li = list(map(int,input().split()))
li.sort()
for i in li:
    if L>=i:
        L+=1
print(L)