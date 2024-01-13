n = int(input())
li = []
for i in range(n):
    li.append(input())
l = list(set(li))
l.sort()
l.sort(key=len)
for i in l:
    print(i)