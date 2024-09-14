n, m = map(int,input().split())
li = []

for _ in range(n):
    li.append(input())
cnt=[]

for i in range(n-7):
    for j in range(m-7):
        B=0
        W=0
        for a in range(i,i+8):
            for b in range(j,j+8):
                if (a+b) % 2 ==0 :
                    if li[a][b]!='W':
                        B+=1
                    if li[a][b] !='B':
                        W+=1
                else:
                    if li[a][b] !='B':
                        B+=1
                    if li[a][b] !='W':
                        W+=1
        cnt.append(B)
        cnt.append(W)
        
print(min(cnt))