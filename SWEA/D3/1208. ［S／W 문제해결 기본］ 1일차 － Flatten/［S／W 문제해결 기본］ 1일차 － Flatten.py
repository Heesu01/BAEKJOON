for T in range(1,11):
    cnt = int(input())
    li = list(map(int,input().split()))
    while (cnt>0):
        li[li.index(max(li))] -= 1
        li[li.index(min(li))] += 1
        cnt-=1
    print(f"#{T} {max(li)-min(li)}")