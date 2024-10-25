T = int(input())
for _ in range(T):
    n,m = map(int,input().split())
    stack = list(map(int,input().split()))
    
    result = 1
    while stack:
        if stack[0] < max(stack):
            stack.append(stack.pop(0))
            
        else:
            if m==0:
                break
        
            stack.pop(0)
            result+=1
        
        m = m -1 if m>0 else len(stack) -1
        
    print(result)
       
                
         