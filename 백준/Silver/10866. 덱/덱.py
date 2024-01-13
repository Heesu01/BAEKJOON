import sys
n = int(sys.stdin.readline())
deque=[]

for _ in range(n):
    cmd = sys.stdin.readline().split()
    
    if cmd[0]=="push_front":
        deque.insert(0,cmd[1])
    elif cmd[0]=="push_back":
        deque.append(cmd[1])
    elif cmd[0]=="pop_front":
        if len(deque)==0:
            print(-1)
        else:
            print(deque.pop(0))
    elif cmd[0]=="pop_back":
        if len(deque)==0:
            print(-1)
        else:
            print(deque.pop())
    elif cmd[0]=="size":
        print(len(deque))
    elif cmd[0]=="empty":
        if len(deque)==0:
            print(1)
        else: print(0)
    elif cmd[0]=="front":
        if len(deque)==0:
            print(-1)
        else:
            print(deque[0])
    elif cmd[0]=="back":
        if len(deque)==0:
            print(-1)
        else:
            print(deque[-1])
        