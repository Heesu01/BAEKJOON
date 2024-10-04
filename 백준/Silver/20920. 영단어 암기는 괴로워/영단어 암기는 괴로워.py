import sys
input = sys.stdin.readline

n,m = map(int,input().split())
set= {}
for _ in range(n):
    word = input().rstrip()
    if len(word) >=  m:
        if word in set:
            set[word]+=1
        else:
            set[word]=1
        
ans= sorted(set.items(), key=lambda x:(-x[1], -len(x[0]), x[0]))

for i in ans:
    print(i[0])
        