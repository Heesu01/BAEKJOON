for _ in range(1,11):
    T = int(input())
    N, M = map(int, input().split())
    ans = 1
    for _ in range(M):
        ans *= N
    print(f"#{T} {ans}")