def solution(s):
    answer = True
    for i in s:
        if i.isdigit():
            continue
        else:
            answer=False
            break
    if len(s)!=6 and len(s)!=4:
        answer=False
    return answer