import sys
input = sys.stdin.readline

n = int(input())
li=[]
for _ in range(n):
    li.append(int(input()))
    
    
if n==0:
    print(0)
    
else:
    m = n * 0.15
    m = int(int(m+0.5))
    li.sort()
    li =li[m:n - m]
    print(int(sum(li)/len(li)+0.5))
    