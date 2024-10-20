li = list(map(int, input().split()))
li.sort()
a, b, c = li
if a + b <= c:
    c = a + b - 1

print(a + b + c)