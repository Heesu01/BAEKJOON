n = int(input())
li = list(map(int, input().split()))
total=0
li.sort()
for i in range(0,n+1):
    new=li[:i]
    total += sum(new)
print(total)