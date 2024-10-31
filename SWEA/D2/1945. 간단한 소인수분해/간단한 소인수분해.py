T = int(input())
for T in range(1,T+1):
    N = int(input())
    li = [2,3,5,7,11]
    result=[]
    for i in li:
        cnt=0
        while N % i ==0:
            cnt+=1
            N//=i
        result.append(cnt)
    print(f"#{T} {result[0]} {result[1]} {result[2]} {result[3]} {result[4]}")