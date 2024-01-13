n=str(input())
li=[0]*10
for i in n:
    num=int(i)
    li[num]+=1

li[6]+=li[9]
li[9]=0
li[6]=(li[6]+1)//2

print(max(li))
    