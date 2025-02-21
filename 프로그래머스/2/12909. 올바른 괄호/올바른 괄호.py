def solution(s):
    answer = False
    stack=[]
    for i in s:
        if i == "(":
            stack.append(i)
        elif i == ")":
            if len(stack)==0:
                answer=False
                stack.append(i)
                break
            stack.pop()
    if len(stack)==0:
        answer=True
    return answer