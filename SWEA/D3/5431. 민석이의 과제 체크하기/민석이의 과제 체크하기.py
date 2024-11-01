T = int(input())
for T in range(1,T+1):
    N,K = map(int,input().split())
    li = list(map(int,input().split()))
    result=[]
    for i in range(1,N+1):
        if i not in li:
            result.append(i)
    result.sort()
    print(f"#{T}", *result)