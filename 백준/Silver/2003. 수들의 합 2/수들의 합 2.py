n, m = map(int, input().split())
a = list(map(int, input().split()))

count = 0
total = 0
start = 0
end = 0

while True:
    if total >= m:
        if total == m:
            count += 1
        total -= a[start]
        start += 1
    else:
        if end == n:
            break
        total += a[end]
        end += 1
print(count)
