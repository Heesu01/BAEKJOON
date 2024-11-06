T = int(input())
for T in range(1,T+1):
    h,m,hh,mm = map(int,input().split())
    nh = h+hh
    nm = m+mm
    while nm>=60:
        nh+=1
        nm-=60
    if nh>12:
        nh -=12
    print(f"#{T} {nh} {nm}")