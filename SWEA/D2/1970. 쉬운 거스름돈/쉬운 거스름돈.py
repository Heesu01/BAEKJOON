T = int(input())
for t in range(1,T+1):
    money = int(input())
    a = money//50000
    money %= 50000
    b = money//10000
    money %= 10000
    c = money//5000
    money %= 5000
    d = money//1000
    money %= 1000
    e = money//500
    money %= 500
    f = money//100
    money %= 100
    g = money//50
    money %= 50
    h = money//10
    money %= 10
    print(f"#{t}\n{a} {b} {c} {d} {e} {f} {g} {h}")