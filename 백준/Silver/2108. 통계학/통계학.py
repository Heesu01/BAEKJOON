import sys
input=sys.stdin.readline

N = int(input())
li=[]
dic=dict()

for _ in range(N):
    num=int(input())
    li.append(num)
    if num in dic:
        dic[num]+=1
    else:
        dic[num]=1


print(round(sum(li)/N))
print(sorted(li)[N//2])

max_freq = 0
maxf=[]
for key,value in dic.items():
    if value>max_freq:
        max_freq=value
        maxf=[key]
    elif value==max_freq:
        maxf.append(key)

if len(maxf)>1:
    maxf.sort()
    print(maxf[1])
else:
    print(maxf[0])

print(max(li)-min(li))