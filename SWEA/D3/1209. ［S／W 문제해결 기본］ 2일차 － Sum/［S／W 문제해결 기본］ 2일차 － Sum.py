for _ in range(10):
    T=int(input())
    li = []
    for _ in range(100):
        li.append(list(map(int, input().split())))
    Rline = 0
    Lline = 0
    max_col = 0
    max_row = 0
    for i in range(100):
        col = sum(li[i])
        if max_col < col:
            max_col = col
        row = 0
        for j in range(100):
            row += li[j][i]
        if max_row < row:
            max_row = row

        Rline += li[i][i]
        Lline += li[i][100 - i - 1]

    print(f"#{T} {max(max_col, max_row, Rline, Lline)}")
