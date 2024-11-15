for t in range(1, 11):
    N = int(input())
    lst = []
    for _ in range(N):
        lst.append(list(map(int, input().split())))

    ans = 0

    for j in range(N):
        state = 0
        for i in range(N):
            if lst[i][j] == 1:
                state = 1
            elif lst[i][j] == 2 and state == 1:
                ans += 1
                state = 0

    print(f"#{t} {ans}")
