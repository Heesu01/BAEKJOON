T = int(input())
for tk in range (1,T+1):    
    N,M = map(int,input().split())
    li= list(map(int,input().split()))
    ans=[]
    for i in range(N-M+1):
        ans.append(sum(li[i:i+M]))
    print(f"#{tk}",max(ans)-min(ans))