import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
K = int(input())
li = [list(map(int, input().split())) for _ in range(K)]

dp = [[0 for _ in range(M+1)] for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, M+1):
        dp[i][j] = dp[i-1][j] + dp[i][j-1] + arr[i-1][j-1] - dp[i-1][j-1]

for line in li:
    i, j, x, y = line
    print(dp[x][y] - (dp[x][j-1] + dp[i-1][y]) + dp[i-1][j-1])