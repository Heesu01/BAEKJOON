t=int(input())
for _ in range(t):
    ps=input()
    stack=[]
    for i in ps:
        if i=="(":
            stack.append(i)
        elif i==")":
            if len(stack)==0:
                stack.append(i)
                break
            else:
                stack.pop()
    if len(stack)!=0:
            print("NO")
    else:
        print("YES")