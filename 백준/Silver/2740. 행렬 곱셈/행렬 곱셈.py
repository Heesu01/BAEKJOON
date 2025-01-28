import sys
input=sys.stdin.readline

def multi(a,b):
    X = [[0]*K for _ in range(N)]
    for i in range(N): 
        for j in range(K):
            for k in range(M):
                X[i][j] += a[i][k]*b[k][j]
    return X


N, M = map(int, input().split())
A = [list(map(int,input().split())) for _ in range(N)]
M, K = map(int, input().split())
B = [list(map(int,input().split())) for _ in range(M)]
for i in multi(A,B):
    print(*i)