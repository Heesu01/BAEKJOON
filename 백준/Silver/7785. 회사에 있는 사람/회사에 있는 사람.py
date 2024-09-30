import sys
input = sys.stdin.readline

n = int(input())
dict = {}

for _ in range(n):
    name, inout = input().split()
    dict[name] = inout
    
    if inout == "leave":
        del dict[name]


dict = sorted(dict.keys(), reverse=True)

for i in dict:
    print(i)