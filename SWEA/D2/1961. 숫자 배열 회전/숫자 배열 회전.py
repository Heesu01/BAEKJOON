T = int(input())
for t in range(1,T+1):
    N = int(input())
    li = list(list(map(int, input().split())) for _ in range(N))

    li3 = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            li3[i][j] = li[j][N - 1 - i]

    li2 = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            li2[i][j] = li3[j][N - 1 - i]

    li1 = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            li1[i][j] = li2[j][N - 1 - i]

    print(f"#{t}")
    for i in range(N):
        print(*li1[i], sep="", end=" ")
        print(*li2[i], sep="", end=" ")
        print(*li3[i], sep="", end=" ")
        print() if t != T else None
