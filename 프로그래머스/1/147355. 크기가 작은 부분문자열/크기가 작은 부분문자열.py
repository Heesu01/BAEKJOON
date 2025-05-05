def solution(t, p):
    answer = 0
    li=[]
    for i in range(len(t)-len(p)+1):
        li.append(t[i:i+len(p)])
    for i in li:
        if i <= p:
            answer+=1
    return answer