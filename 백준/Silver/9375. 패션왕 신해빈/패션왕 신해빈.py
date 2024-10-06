T = int(input())

for _ in range(T):
    n = int(input())
    dict = {}
    for _ in range(n):
            name,sort = input().rstrip().split()
            if sort not in dict:
                dict[sort]=1
            else:
                dict[sort]+=1

    ans=1
    for i in dict:
        ans *= (dict[i] + 1)
    
    print(ans - 1)
    


