def solution(s):
    answer = True
    li=[]
    for i in s:
        if i == "(":
            li.append(i)
        elif i==")":
            if len(li)==0:
                answer=False
                break
            else:
                li.pop()
            
    if len(li)!=0:
        answer = False
    return answer