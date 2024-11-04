T = int(input())
for T in range(1,T+1):
    li = list(map(int,input().split()))
    li.remove(min(li))
    li.remove(max(li))
    result = round(sum(li)/len(li))
    print(f"#{T} {result}")