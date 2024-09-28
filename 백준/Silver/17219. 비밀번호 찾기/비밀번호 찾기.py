import sys
input = sys.stdin.readline

n,m = map(int,input().split())
dict = {}

for _ in range(n):
    url,pw = input().rstrip().split()
    dict[url]=pw
    
for _ in range(m):
    ans= input().rstrip()
    print(dict[ans])