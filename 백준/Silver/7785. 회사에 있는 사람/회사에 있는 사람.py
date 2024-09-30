import sys
input=sys.stdin.readline

n = int(input())
li=set()
for _ in range(n):
    name,inout = map(str,input().split())
    if inout=="enter":
        li.add(name)
    elif inout=="leave":
        li.remove(name)
li = sorted(li, reverse=True)
for i in li:
    print(i)