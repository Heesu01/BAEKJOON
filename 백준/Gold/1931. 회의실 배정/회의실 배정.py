import sys
input= sys.stdin.readline
N = int(input())
li = []

for i in range(N):
    start, end = map(int,input().split())
    li.append((start, end))

li.sort(key=lambda x : (x[1],x[0]))

count = 1
end = li[0][1]

for i in range(1, N):
    if li[i][0]>=end:
        end = li[i][1]
        count += 1

print(count)