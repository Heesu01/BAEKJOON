i=0

ans_data =[]

while True:
    i+=1
    l,p,v = map(int, input().split())
    
    if (l==0) & (p==0) & (v==0):
        break
    
    r=v%p
    if l< r:
        r=l
        
    ans = (v//p)*l+r
    
    ans_data.append(ans)
    
for i in range(len(ans_data)):
    print('Case %d: %d'%(i+1,ans_data[i]))