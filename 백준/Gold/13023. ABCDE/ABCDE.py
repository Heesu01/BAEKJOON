import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

N,M = map(int,input().split())
A = [[] for _ in range(N+1)]
visited = [False] * (N+1)
arrive= False

def DFS(now,depth):
    global arrive
    if depth ==5:
        arrive=True
        return
    visited[now]=True
    for i in A[now]:
        if not visited[i]:
            DFS(i,depth+1)
    visited[now]=False

for _ in range(M):
    a,b = map(int,input().split())
    A[a].append(b)
    A[b].append(a)

for i in range(N):
    DFS(i,1)
    if arrive:
        break
        
if arrive:
    print(1)
else:
    print(0)
        