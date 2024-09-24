import sys
input=sys.stdin.readline

s=set()
n=int(input())
for _ in range(n):
    cmd=input().split()
    if cmd[0]=="add":
        s.add(int(cmd[1]))
    elif cmd[0]=="remove":
        s.discard(int(cmd[1]))
    elif cmd[0]=="check":
        if int(cmd[1]) in s:
            print(1)
        else:
            print(0)
    elif cmd[0]=="toggle":
        if int(cmd[1]) in s:
            s.discard(int(cmd[1]))
        else:
            s.add(int(cmd[1]))
    elif cmd[0]=="all":
        s=set([i for i in range(1,21)])
    elif cmd[0]=="empty":
        s=set()