for _ in range(1,11):
    T = int(input())
    li = list(map(int, input().split()))
    num = 1
    while True:
        if num > 5:
            num = 1

        first = li.pop(0) - num

        if first <= 0:
            li.append(0)
            break
        else:
            li.append(first)

        num += 1

    print(f"#{T} ",*li)