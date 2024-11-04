for T in range(10):
    N = int(input())
    li = list(map(int,input().split()))
    result=0
    for i in range(2,N-2):
        maxBuilding = max(li[i-1],li[i-2],li[i+1],li[i+2])
        if li[i] > maxBuilding:
            result+=(li[i]-maxBuilding)
    print(f"#{T+1} {result}")