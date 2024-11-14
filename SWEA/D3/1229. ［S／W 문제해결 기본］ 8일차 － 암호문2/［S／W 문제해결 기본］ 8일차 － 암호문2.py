for t in range(1,11):
    N = int(input())
    li = list(map(int, input().split()))
    cmd_N = int(input())
    cmd = input().split()

    i = 0
    while i < len(cmd):
        if cmd[i] == "I":
            start = int(cmd[i + 1])
            n = int(cmd[i + 2])
            insert =  map(int, cmd[i + 3:i + 3 + n])
            li = li[:start] + list(insert) + li[start:]
            i += 3 + n
        elif cmd[i] == "D":
            start = int(cmd[i + 1])
            n = int(cmd[i + 2])
            li = li[:start] + li[start + n:]
            i += 3
        else:
            i += 1
    print(f"#{t}",end=" ")
    print(*li[:10])



