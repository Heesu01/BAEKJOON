li = [list(map(int, input().split())) for _ in range(9)]

maxnum = 0
a,b =0, 0

for i in range(9):
    for j in range(9):
        if maxnum <= li[i][j]:
            maxnum = li[i][j]
            a = i +1
            b = j + 1
            
print(maxnum)
print(a, b)