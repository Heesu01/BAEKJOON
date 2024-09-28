n,m = map(int,input().split())
dict = {}

for _ in range(n):
    url,pw = input().split()
    dict[url]=pw
    
for _ in range(m):
    ans= input()
    print(dict[ans])