n,m = map(int,input().split())
dict = {}

for num in range(1,n+1):
    po =input()
    dict[num] = po
    dict[po] = num

for i in range(m):
    ans=input()
    if ans.isdigit():
        print(dict[int(ans)])
    else:
        print(dict[ans])