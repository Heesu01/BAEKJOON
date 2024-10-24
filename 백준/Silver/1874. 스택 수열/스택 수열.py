n = int(input())
stack=[]
cur=1
ans=[]
for _ in range(n):
    num = int(input())
    
    while cur <=num:
        stack.append(cur)
        ans.append("+")
        cur+=1
    if stack[-1]==num:
        stack.pop()
        ans.append("-")
    else:
        ans.clear()
        print("NO")
        break
if len(ans)>0:
    for i in ans:
        print(i)
    