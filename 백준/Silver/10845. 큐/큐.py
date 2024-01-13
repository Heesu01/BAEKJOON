import sys
n =int(sys.stdin.readline())
que = []

for _ in range(n):
    word = sys.stdin.readline().split()
    cmd = word[0]
    
    if cmd=="push":
        que.append(word[1])
    elif cmd=="pop":
        if len(que)==0:
            print(-1)
        else:
            print(que.pop(0))
    elif cmd=="size":
        print(len(que))
    elif cmd =="empty":
        if len(que)==0:
            print(1)
        else:
            print(0)
    elif cmd=="front":
        if len(que)==0:
            print(-1)
        else:
            print(que[0])
    elif cmd=="back":
        if len(que)==0:
            print(-1)
        else:
            print(que[-1])