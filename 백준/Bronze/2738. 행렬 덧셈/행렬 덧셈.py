n,m = map(int, input().split())
A=[]
B=[]

for i in range(n):
    num = list(map(int,input().split()))
    A.append(num)
    
for i in range(n):
    num = list(map(int,input().split()))
    B.append(num)
    
for i in range(n):
    for j in range(m):
        print(A[i][j]+ B[i][j], end=" ")
    print()
