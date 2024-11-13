
for T in range(1,11):
    N = int(input())
    li = []
    cnt = 0
    for _ in range(8):
        li.append(input())

    # 행 row
    for i in li:
        for j in range(0, 8 - N + 1):
            ans = i[j:j + N]
            if ans == ans[::-1]:
                cnt += 1
    
    # 열 col
    for i in zip(*li):
        for j in range(0, 8 - N + 1):
            ans = i[j:j + N]
            if ans == ans[::-1]:
                cnt += 1

    print(f"#{T} {cnt}")

