import sys
input = sys.stdin.readline

x = int(input())
li=[64]
while sum(li) > x:
    tmp = li.pop()/2
    li.append(tmp)
    li.append(tmp)
    if sum(li[:-1])>=x:
        li.pop()
print(len(li))
    