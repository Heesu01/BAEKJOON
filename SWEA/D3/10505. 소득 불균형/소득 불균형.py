T = int(input())
for T in range (1,T+1):
    N = int(input())
    li = list(map(int, input().split()))
    cnt=0
    for i in li:
        if i <=(sum(li)/N):
            cnt+=1
    print(f"#{T} {cnt}")