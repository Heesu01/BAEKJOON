T = int(input())
for T in range(1,T+1):
    N = int(input())
    li = list(map(int,input().split()))
    li = li[::-1]
    profit = 0
    current=li[0]
    for i in li:
        if i<current:
            profit += (current - i)
        else:
            current = i
    print(f"#{T} {profit}")
        