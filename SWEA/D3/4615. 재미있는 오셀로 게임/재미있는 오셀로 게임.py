T = int(input())
for t in range(1,T+1):
    direct = ((0, 1), (1, 0), (-1, 0), (0, -1), (1, 1), (1, -1), (-1, 1), (-1, -1))
    N, M = map(int, input().split())

    board = [[0] * N for _ in range(N)]

    mid = N // 2

    board[mid][mid] = 2
    board[mid - 1][mid - 1] = 2
    board[mid - 1][mid] = 1
    board[mid][mid - 1] = 1

    for i in range(M):
        x, y, c = map(int, input().split())
        y, x = y - 1, x - 1

        reverse = []

        for i in range(8):
            dx, dy = direct[i]
            nx, ny = x + dx, y + dy
            while True:
                if nx < 0 or ny < 0 or ny > N - 1 or nx > N - 1:
                    reverse = []
                    break
                if board[nx][ny] == 0:
                    reverse = []
                    break
                if board[nx][ny] == c:
                    break
                else:
                    reverse.append((nx, ny))
                    nx, ny = nx + dx, ny + dy
            for rx, ry in reverse:
                if c == 1:
                    board[rx][ry] = 1
                else:
                    board[rx][ry] = 2
        board[x][y] = c

    w, b = 0, 0
    for i in range(N):
        for j in range(N):
            if board[i][j] == 1:
                w += 1
            elif board[i][j] == 2:
                b += 1
    print(f"#{t} {w} {b}")


