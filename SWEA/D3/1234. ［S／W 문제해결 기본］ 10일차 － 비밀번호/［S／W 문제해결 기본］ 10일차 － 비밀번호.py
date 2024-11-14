for t in range(1,11):
    n, num = input().split()
    num = list(num)
    while True:
        found = False
        for i in range(len(num) - 1):
            if num[i] == num[i + 1]:
                num.pop(i + 1)
                num.pop(i)
                found = True
                break
        if not found:
            break

    print(f'#{t}',"".join(num))