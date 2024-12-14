K,N = map(int,input().split())
li=[]
for _ in range(K):
    li.append(int(input()))

start, end = 1, max(li)

while start <= end:
    mid = (start + end) // 2
    lines = 0
    for i in li:
        lines += i // mid

    if lines >= N:
        start = mid + 1
    else:
        end = mid - 1

print(end)