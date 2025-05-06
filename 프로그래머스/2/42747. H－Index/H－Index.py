def solution(citations):
    answer = 0
    for h in range(max(citations),-1,-1):
        cnt=0
        for j in citations:
            if j>=h:
                cnt+=1
        if cnt>=h:
            answer=h
            break
    return answer