for t in range(1,11):
    N = int(input())
    li = list(map(int, input().split()))
    cmd_N = int(input())
    cmd = list(map(str, input().split("I")))
    new_cmd = []
    for i in cmd[1:]:
        new_cmd.append(i.split())

    for i in new_cmd:
        start = int(i[0])
        n = int(i[1])
        insert = i[2:]
        li = li[:start] + insert + li[start:]

    print(f"#{t}",end=" ")
    print(*li[:10])

