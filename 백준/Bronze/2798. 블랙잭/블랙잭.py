n,m = map(int,input().split())
cards=list(map(int,input().split()))

li=[]
add=0
for i in range(len(cards)-2):
    for j in range(i+1,len(cards)-1):
        for k in range(j+1,len(cards)):
            add=cards[i]+cards[j]+cards[k]
            if add <=m:
                li.append(add)
print(max(li))