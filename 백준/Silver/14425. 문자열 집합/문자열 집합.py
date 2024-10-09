import sys
input = sys.stdin.readline

n, m = map(int,input().split())
s=set()
cnt=0
for _ in range(n):
    s.add(input().rstrip())
for _ in range(m):
    word = input().rstrip()
    if word in s:
        cnt +=1
print(cnt)