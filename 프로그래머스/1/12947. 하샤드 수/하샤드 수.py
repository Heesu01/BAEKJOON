def solution(x):
    x = str(x)
    num = 0
    for i in range(len(x)):
        num+=int(x[i])
    
    if int(x) % num ==0:
        answer = True
    else:
        answer = False
    
    return answer