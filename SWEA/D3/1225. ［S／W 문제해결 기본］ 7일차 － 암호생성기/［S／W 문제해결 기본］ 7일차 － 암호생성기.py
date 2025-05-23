for _ in range(10):
    n = int(input())
    li = list(map(int,input().split()))
    while li[-1]!=0:
        for i in range(1,6):
            if li[0]-i < 0:
                li.append(0)
                li.pop(0)
                break
            li.append(li[0]-i)
            li.pop(0)
            if li[-1]==0:
                break
    print(f"#{n}", *li)